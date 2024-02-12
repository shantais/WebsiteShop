package com.bestbuykamps.websiteshop.data_model;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    private  Integer userId;
    @Column(name = "username")
    private  String username;
    @Column(name = "password")
    private  String password;


    public User(String username, Integer userId, String password) {
        this.username = username;
        this.userId = userId;
        this.password = password;
    }

    public User() {

    }


    public Integer getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public  String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
