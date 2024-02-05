package com.bestbuykamps.websiteshop.data_model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();// zamienić na mapę
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


    public void addCartItem(CartItem cartItem) {
        //zmienić logikę
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }

    public void removeCartItemById(Long cartItemId) {
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
