package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.data_model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
public class Product_Controller {

    // tutaj wypełnić listę danymi z bazy, tymczasowo wpisałam na sztywno
    private static final List<Product> PRODUCTS = Arrays.asList(
            new Product(1L, "The Sims"),
            new Product(2L, "Hogwarts Legacy")
    );

    @GetMapping("productId")
    public Product getProducts (@PathVariable("productId") Long productId){
        return PRODUCTS.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(()->new IllegalStateException(
                        "Game " + productId + " does not exist!"
                ));
    }

}
