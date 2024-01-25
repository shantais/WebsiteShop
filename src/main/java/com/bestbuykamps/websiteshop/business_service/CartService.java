package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.CartRepository;


public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
}
