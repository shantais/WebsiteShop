package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.data_model.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // dodanie do koszyka
    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product){
        this.cartService.addProductToCart(product);
    }

    // usunięcie z koszyka
    @RequestMapping(path = "/products", method = RequestMethod.DELETE)
    public void deleteProduct(@RequestBody Product product) {
        this.cartService.deleteProductFromCart(product);
    }

    // zwiększenie quantity dla obiektu z listy koszyka
    // zmniejszenie quantity dla obiektu z listy koszyka

    // wyślij zamówienie???
}
