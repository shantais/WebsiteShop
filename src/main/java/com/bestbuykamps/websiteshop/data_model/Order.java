package com.bestbuykamps.websiteshop.data_model;
import jakarta.persistence.*;

@Entity
public class Order {

    @Id
    private Long id;

    @OneToOne
    private Cart cart;

    @OneToOne
    private User user;

    public Order() {
    }

    public Order(Long id, Cart cart, User user) {
        this.id = id;
        this.cart = cart;
        this.user = user;
    }

    // Gettery i Settery

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}