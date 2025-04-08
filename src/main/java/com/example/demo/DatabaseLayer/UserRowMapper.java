package com.example.demo.DatabaseLayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.User;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user =new User();
        user.setUserId(rs.getInt(1));
        user.setUserName(rs.getString(2));
        user.setEmail(rs.getString(3));
        user.setPassword(rs.getString(4));
        return user;
    }
    
}
