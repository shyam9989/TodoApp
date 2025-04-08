package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DatabaseLayer.TodoDatabase;
import com.example.demo.model.Todo;
import com.example.demo.service.InsertTodo;

@Service
public class InsertTodoService implements InsertTodo {

    TodoDatabase todoDatabase;

    @Autowired
    public void setTodoDatabase(TodoDatabase todoDatabase) {
        this.todoDatabase = todoDatabase;
    }

    @Override
    public int insertTodo(Todo todo) {
   return todoDatabase.insertIntoDb(todo);

    }

}
