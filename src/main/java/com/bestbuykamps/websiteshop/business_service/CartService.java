package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.CartRepository;
import com.bestbuykamps.websiteshop.data_model.ProductRepository;

public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
}
