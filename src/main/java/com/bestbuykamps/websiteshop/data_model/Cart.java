package com.bestbuykamps.websiteshop.data_model;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    static private Map<Long, Integer> cartMap = new HashMap<>() ;
    @Column(name = "user_id")
    private Long userId;


    public Map<Long, Integer> getCartMap() {
        return cartMap;
    }
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
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }

    public void removeCartItemById(Long cartItemId) {
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();
            if (cartItem.getId().equals(cartItemId)) {
                iterator.remove();
                cartItem.setCart(null);
                break;
            }
        }
    }


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + userId +
                '}';
    }
}
