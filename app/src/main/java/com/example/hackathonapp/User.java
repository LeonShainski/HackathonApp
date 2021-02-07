package com.example.hackathonapp;

public class User {
    public String name;
    public String age;
    public String occupation;

    public User() {

    }
    public User (String name, String age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String occupation() {
        return occupation;
    }
}
