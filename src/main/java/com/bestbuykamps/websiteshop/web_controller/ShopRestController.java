package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.ProductService;
import com.bestbuykamps.websiteshop.data_model.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopRestController {
    private final ProductService productService;

    public ShopRestController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product){
        this.productService.addProduct(product);
    }

    @RequestMapping(path = "/products", method = RequestMethod.DELETE)
    public void deleteProduct(@RequestBody Product product) {
        this.productService.deleteProduct(product);
    }
}
