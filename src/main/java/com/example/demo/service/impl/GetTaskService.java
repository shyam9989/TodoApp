package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DatabaseLayer.TodoDatabase;
import com.example.demo.model.Todo;

@Service
public class GetTaskService {

    TodoDatabase todoDatabase;

    @Autowired
    public void setTodoDatabase(TodoDatabase todoDatabase) {
        this.todoDatabase = todoDatabase;
    }

    public Todo sendTaskOne(int taskId) {

        Todo todo = null;

        try {

            todo = todoDatabase.getTaskOneFromDb(taskId);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return todo;

    }

    public List<Todo> getAllTodos(){

        return todoDatabase.getAllTodos();
    }

    public int deleteTask(int taskId){
        return todoDatabase.deleteTodo(taskId);
    }

}
