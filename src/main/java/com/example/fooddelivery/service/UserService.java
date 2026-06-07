package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.User;

import java.util.List;

public interface UserService {

    User register(User user);

    User login(String email,
               String password);

    List<User> getAllUsers();
}