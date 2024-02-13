package com.bestbuykamps.websiteshop.data_model;
import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private  String username;
    public Order() {
    }


    // Gettery i Settery

    public Long getId() {
        return id;
    }


}