package com.example.fooddelivery.controller;

import com.example.fooddelivery.dto.LoginRequest;
import com.example.fooddelivery.entity.User;
import com.example.fooddelivery.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return service.register(user);
    }

    @PostMapping("/login")
    public User login(
            @RequestBody LoginRequest request) {
    	System.out.println("LOGIN API HIT");

        return service.login(
                request.getEmail(),
                request.getPassword());
    }

    @GetMapping
    public List<User> getAllUsers() {

        return service.getAllUsers();
    }
}