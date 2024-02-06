package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart/products")
public class CartController {
    private final CartService cartService;
    private Long productId;
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    @GetMapping("/cart")
    public String showCartPage() {
        return "redirect:forward:/CART_PAGE.html";
    }
    @GetMapping("/")
    public String showProductsPage() {
        return "redirect:forward:/PRODUCTS_PAGE.html";
    }
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping("/add")
    public String addProductToCart(@RequestParam Long productId) {
        cartService.addProductToCart(productId);
        logger.info("Product with ID {} added to cart", productId);
        return "redirect:forward:/PRODUCT_ADDED.html";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long productId) {
        this.cartService.deleteProductFromCart(productId);
        logger.info("Product with ID {} deleted from cart", productId);
        return "redirect:forward:/PRODUCT_ADDED.html";
    }

    // zwiększenie quantity dla obiektu z listy koszyka
    // zmniejszenie quantity dla obiektu z listy koszyka

    // wyślij zamówienie???
}
