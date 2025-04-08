package com.example.demo.DatabaseLayer;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Todo;

public class TodoRowMapper  implements RowMapper<Todo>{

    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
      
        Todo todo=new Todo();
          todo.setId(rs.getInt(1));
          todo.setTaskName(rs.getString(2));
          todo.setTaskDate(rs.getDate(3).toLocalDate());
          todo.setTaskStatus(rs.getString(4));

        return todo;
    }
    
}
