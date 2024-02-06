package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.business_service.ProductService;
import com.bestbuykamps.websiteshop.data_model.CartItem;
import com.bestbuykamps.websiteshop.data_model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopRestController {
    private final ProductService productService;
    private final CartService cartService;

    public ShopRestController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
    }

    @RequestMapping(path = "/products", method = RequestMethod.DELETE)
    public void deleteProduct(@RequestBody Product product) {
        this.productService.deleteProduct(product);
    }


    @RequestMapping(path = "/cart/cartitemlist", method = RequestMethod.GET)
    public List<CartItem> getCart() {
        return this.cartService.getCartItems();
    }
}
