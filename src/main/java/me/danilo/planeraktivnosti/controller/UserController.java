package me.danilo.planeraktivnosti.controller;

import me.danilo.planeraktivnosti.model.User;
import me.danilo.planeraktivnosti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers() {
        userService.getUserByUsername("Marko");
        return "test";
    }

}
