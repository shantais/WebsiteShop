package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.ProductService;
import com.bestbuykamps.websiteshop.data_model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("/products")
public class Product_Controller {

    private final ProductService productService;

    // tutaj wypełnić listę danymi z bazy, tymczasowo wpisałam na sztywno
    private static final List<Product> PRODUCTS = Arrays.asList(
            new Product(1L, "The Sims"),
            new Product(2L, "Hogwarts Legacy")
    );

    public Product_Controller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("productId")
    public Product getProducts (@PathVariable("productId") Long productId){
        return PRODUCTS.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(()->new IllegalStateException(
                        "Game " + productId + " does not exist!"
                ));
    }

    @GetMapping(path="products")
    public List<Product> productList() {
        return PRODUCTS;
    }

}
