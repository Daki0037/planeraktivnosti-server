package me.danilo.planeraktivnosti.controller;

import me.danilo.planeraktivnosti.model.User;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) {

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/register")
    public void registerUser() {

    }

}
