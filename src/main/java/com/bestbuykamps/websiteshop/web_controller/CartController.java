package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.data_model.CartItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cart/products")
public class CartController {
    private final CartService cartService;
    private Long productId;
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    @GetMapping("/cart")
    public String showCartPage(Model model) {
        List<CartItem> cartItems = cartService.getCartItems(1L);
        model.addAttribute("cartItems", cartItems);
        return "shopping-cart";
    }

    @GetMapping("/")
    public String showProductsPage() {
        List<CartItem> cartItems = cartService.getCartItems(1L);
        if (cartItems.isEmpty()) {
            return "redirect:/cart";
        } else {
            return "redirect:/products";
        }
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
    @PostMapping("/remove")
    public String removeProduct(@RequestParam Long cartId, Long productId ) {
        this.cartService.deleteProductFromCart(cartId,productId);
        logger.info("Product with ID {} removed from cart", productId);
        return "redirect:forward:/PRODUCT_REMOVED.html";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long cartId, Long productId) {
        this.cartService.deleteProductFromCart(cartId,productId);
        logger.info("Product with ID {} deleted from cart", productId);
        return "redirect:forward:/PRODUCT_DELETE.html";
    }

    // zwiększenie quantity dla obiektu z listy koszyka
    // zmniejszenie quantity dla obiektu z listy koszyka

    // wyślij zamówienie???
}
