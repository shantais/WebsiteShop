package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart/products")
public class CartController {
    private final CartService cartService;
    private Long productId;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping("/add")
    public String addProductToCart(@RequestParam Long productId) {
        cartService.addProductToCart(productId);
        return "redirect:forward:/PRODUCT_ADDED.html";
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
