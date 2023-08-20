package me.danilo.planeraktivnosti.controller;

import me.danilo.planeraktivnosti.model.User;
import me.danilo.planeraktivnosti.repository.UserRepository;
import me.danilo.planeraktivnosti.service.AuthService;
import me.danilo.planeraktivnosti.service.UserService;
import org.apache.coyote.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private UserRepository userRepository;
    private AuthService authService;

    @Autowired
    public AuthController(UserRepository userRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) throws NoSuchAlgorithmException {
        if(userRepository.existsUserByUsername(user.getUsername())) {
            User foundUser = userRepository.findUserByUsername(user.getUsername());
            String foundUserPassword = foundUser.getPassword();
            String password = authService.getHashedPassword(user.getPassword());

            Map<String, String> data = new HashMap<>();

            if(foundUserPassword.equalsIgnoreCase(password)) {
                data.put("authenticated", "true");
                data.put("id", Integer.toString(foundUser.getId()));

                JSONObject jsonResponse = new JSONObject(data);

                return ResponseEntity.ok(jsonResponse.toString());
            }
            else {
                data.put("authenticated", "false");
                return new ResponseEntity<>(data, HttpStatus.OK);
            }

        }
        return ResponseEntity.badRequest().body("User not found");
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) throws NoSuchAlgorithmException {
        if(userRepository.existsUserByUsername(user.getUsername()))
            return ResponseEntity.badRequest().body("Username already exists");

        String password = authService.getHashedPassword(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
