package com.bestbuykamps.websiteshop.model;

public class User {
    private final Integer userId;
    private final String username;


    public User(String username, Integer userId) {
        this.username = username;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
