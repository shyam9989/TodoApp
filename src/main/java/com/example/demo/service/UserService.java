package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    int userRegister(User user);
    User userLogin(User user);
    
}
