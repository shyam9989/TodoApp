package com.example.demo.service;

import com.example.demo.model.Todo;


@FunctionalInterface
interface GetTaskOne {

    public Todo getTask(int taskId);
    
}
