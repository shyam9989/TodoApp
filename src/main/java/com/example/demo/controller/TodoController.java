package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Todo;
import com.example.demo.service.impl.GetTaskService;
import com.example.demo.service.impl.InsertTodoService;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/todo")
public class TodoController {

    InsertTodoService todoService;
    GetTaskService getTaskOne;

    @Autowired
    public void setTodoService(InsertTodoService todoService) {
        this.todoService = todoService;
    }

    @Autowired
    public void setGetTaskOne(GetTaskService getTaskService) {
        this.getTaskOne = getTaskService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/")
    public ResponseEntity<Todo> insertTask(@RequestBody Todo todo) {

        int i = todoService.insertTodo(todo);
        if (i != 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Todo>(todo, HttpStatus.OK);
        }

    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Todo> getTask(@PathVariable int taskId,Principal principal) {

        System.out.println("username is"+principal.getName());
        Todo todo = Optional.ofNullable(getTaskOne.sendTaskOne(taskId))
                .orElseThrow(() -> new RuntimeException("resource not found"));

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTaskList() {

        List<Todo> todoLists = Optional.ofNullable(getTaskOne.getAllTodos())
                .orElse(Arrays.asList());

        return new ResponseEntity<>(todoLists, HttpStatus.OK);

    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Integer> deleteTodo(@PathVariable int taskId) {

        Optional<Integer> optional = Optional.ofNullable(getTaskOne.deleteTask(taskId));

        Optional<ResponseEntity<Integer>> map = optional.filter((s) -> s == 1)
                .map((s) -> new ResponseEntity<>(HttpStatus.OK));

        return map.get();

    }

}
