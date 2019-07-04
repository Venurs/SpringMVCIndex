package com.yanyd.entity;

public class Account {
    private int userId;
    private int age;
    private String username;
    private String password;

    public Account(){}
    public Account(int userId, int age, String username, String password){
        this.age = age;
        this.userId=userId;
        this.username=username;
        this.password=password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
