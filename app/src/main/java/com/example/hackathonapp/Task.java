package com.example.hackathonapp;

public class Task {
    public String taskName;
    public String Category;

    public Task() {

    }
    public Task (String taskName, String Category) {
        this.taskName = taskName;
        this.Category = Category;
    }

    public String getName() {
        return taskName;
    }

    public String Category() {
        return Category;
    }

}
