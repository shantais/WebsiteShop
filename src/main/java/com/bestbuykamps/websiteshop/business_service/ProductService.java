package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.Discount;
import com.bestbuykamps.websiteshop.data_model.Product;
import com.bestbuykamps.websiteshop.data_model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // metoda na wyciągnięcie wszystkich produktów z bazy do listy
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
