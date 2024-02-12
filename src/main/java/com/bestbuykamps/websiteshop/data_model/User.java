package com.bestbuykamps.websiteshop.data_model;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer userId;
    @Column(name = "username")
    private  String username;
    @Column(name = "password")
    private  String password;


    public User(String username, String password) {
        this.username = username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
