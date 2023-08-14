package me.danilo.planeraktivnosti.service;

import me.danilo.planeraktivnosti.model.User;
import me.danilo.planeraktivnosti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void getUserByUsername(String username) {
        List<User> users = userRepository.findAll();
        for(User user : users) {
            System.out.println(user.getUsername());
        }
    }

}
