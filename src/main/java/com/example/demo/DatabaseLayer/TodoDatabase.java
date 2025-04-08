package com.example.demo.DatabaseLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.example.demo.model.Todo;

@Component
public class TodoDatabase {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertIntoDb(Todo todo) {

        int update = 0;
        try {
            update = jdbcTemplate.update("insert into task values(?,?,?,?)", todo.getId(), todo.getTaskName(),
                    todo.getTaskDate(), todo.getTaskStatus());
        } catch (Exception e) {
            e.printStackTrace();

        }

        return update;
    }

    public Todo getTaskOneFromDb(int taskId) {

        return jdbcTemplate.queryForObject("select * from task where taskId=?", new Object[] { taskId }, (rs, num) -> {
            Todo todo = new Todo();
            todo.setId(rs.getInt(1));
            todo.setTaskName(rs.getString(2));
            todo.setTaskDate(rs.getDate(3).toLocalDate());
            todo.setTaskStatus(rs.getString(4));
            return todo;

        });

    }

    public List<Todo> getAllTodos() {

        return jdbcTemplate.query("select * from task", new TodoRowMapper());

    }

    public int deleteTodo(int taskId) {
        return jdbcTemplate.update("delete from task where taskId=?", new Object[] { taskId });
    }

}
