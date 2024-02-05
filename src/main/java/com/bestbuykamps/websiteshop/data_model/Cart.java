package com.bestbuykamps.websiteshop.data_model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    static private Map<Long,Integer> cartItems;

    @Column(name = "user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public void addProductToCart(Long productId) {
        //zmienić logikę
    }

    public void removeProductFromCart(Long productId) {
       //dodać logikę
    }

    //metoda na wyszukanie  w mapie po id produktu


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + userId +
                '}';
    }
}
