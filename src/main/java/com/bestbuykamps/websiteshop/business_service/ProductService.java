package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.ProductRepository;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
