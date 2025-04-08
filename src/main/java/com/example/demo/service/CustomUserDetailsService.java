package com.example.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.DatabaseLayer.UserDatabase;
import com.example.demo.model.User;

@Component
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    UserDatabase userDatabase;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user= userDatabase.findByUserName(username);
        
        if(Objects.isNull(user)){
         System.out.println("User not available");
         throw new UsernameNotFoundException("user not found");
        }

        return new CustomUserDetails(user);
       

    }
    
}
