package me.danilo.planeraktivnosti.controller;

import me.danilo.planeraktivnosti.model.User;
import me.danilo.planeraktivnosti.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) {
        if(userRepository.existsUserByUsername(user.getUsername())) {
            User foundUser = userRepository.findUserByUsername(user.getUsername());
            String password = foundUser.getPassword();

            if(password.equalsIgnoreCase(user.getPassword())) {
                // Sifra je tacna
            }
            else {
                // Sifra nije tacna
            }

        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) {
        if(userRepository.existsUserByUsername(user.getUsername()))
            return ResponseEntity.badRequest().body("Username already exists");

        userRepository.save(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
