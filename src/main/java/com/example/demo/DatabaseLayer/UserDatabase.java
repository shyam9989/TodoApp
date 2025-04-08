package com.example.demo.DatabaseLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
public class UserDatabase {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertUserDb(User user){

    return jdbcTemplate.update("insert into user values(0,?,?,?)",user.getUserName(),user.getEmail(),user.getPassword());

        
    }

    public User findByUserName(String username) {
        
        return jdbcTemplate.queryForObject("select * from user where userName=?", new Object[]{username},new UserRowMapper());
    }
    
}
