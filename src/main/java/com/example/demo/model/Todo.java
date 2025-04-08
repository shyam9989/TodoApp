package com.example.demo.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo {

    int id;
    String taskName;
    LocalDate taskDate;
    String taskStatus;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
   
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    public LocalDate getTaskDate() {
        return taskDate;
    }
    public void setTaskDate(LocalDate date) {
        this.taskDate = date;
    }
    @Override
    public String toString() {
        return "Todo [id=" + id + ", taskName=" + taskName + ", taskDate=" + taskDate + ", taskStatus=" + taskStatus
                + "]";
    }

    
    

    
}
