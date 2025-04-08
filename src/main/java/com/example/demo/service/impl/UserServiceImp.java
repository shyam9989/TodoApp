package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DatabaseLayer.UserDatabase;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImp implements UserService {

    UserDatabase userDatabase;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public void setUserDatabase(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    @Override
    public int userRegister(User user) {
         user.setPassword(encoder.encode(user.getPassword()));
        return userDatabase.insertUserDb(user);

    }

    @Override
    public User userLogin(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userLogin'");
    }

}
