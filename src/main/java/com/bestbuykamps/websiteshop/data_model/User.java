package com.bestbuykamps.websiteshop.data_model;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long userId;
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

}
