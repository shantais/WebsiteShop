package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.data_model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private Long productId;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // dodanie do koszyka
    @RequestMapping(path = "/products/{productId}", method = RequestMethod.POST)
    public void addProduct(@PathVariable Long productId){
        this.productId = productId;
        this.cartService.addProductToCart(productId);
    }

    // usunięcie z koszyka
    @RequestMapping(path = "/products/{productID}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long productId) {
        this.cartService.deleteProductFromCart(productId);
    }

    // zwiększenie quantity dla obiektu z listy koszyka
    // zmniejszenie quantity dla obiektu z listy koszyka

    // wyślij zamówienie???
}
