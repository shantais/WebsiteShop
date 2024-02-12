package com.bestbuykamps.websiteshop.data_model;
import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    private Long id;


    public Order() {
    }

    public Order(Long id, Cart cart, User user) {
        this.id = id;
    }

    // Gettery i Settery

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}