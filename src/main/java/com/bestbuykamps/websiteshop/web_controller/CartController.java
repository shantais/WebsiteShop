package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.data_model.CartItem;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    //TODO: zdecydować gdzie pobieramy sesje HttpServletRequest request
//    @GetMapping("/cart")
//    public String showCartPage(Model model, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        String sessionId = session.getId();
//        model.addAttribute("sessionId", sessionId);
//        List<CartItem> cartItems = cartService.getCartItems(1L);
//        model.addAttribute("cartItems", cartItems);
//        return "CART_PAGE";
//    }
    @GetMapping("/cart")
    public String showCartPage(Model model , HttpServletRequest request) {
        List<CartItem> cartItems = cartService.getCartItems(request.getRequestedSessionId());
        model.addAttribute("cartItems", cartItems);
        return "CART_PAGE";
    }

    @GetMapping("/")
    public String showProductsPage(HttpServletRequest request) {

        List<CartItem> cartItems = cartService.getCartItems(request.getRequestedSessionId());
        if (cartItems.isEmpty()) {
            return "redirect:/cart";
        } else {
            return "redirect:/products";
        }
    }
    @PostMapping("/add")
    public String addProductToCart(@RequestParam Long productId,HttpServletRequest request) {
        logger.info(request.getRequestedSessionId());
        cartService.addProductToCart(request.getRequestedSessionId(),productId);
        logger.info("Product with ID {} added to cart", productId);
        return "redirect:forward:/";
//        return "redirect:forward:/PRODUCT_ADDED.html";
    }
    @PostMapping("/plus")
    public String plusProductToCart(@RequestParam Long productId,HttpServletRequest request) {
        cartService.addProductToCart(request.getRequestedSessionId(),productId);
        logger.info("Product with ID {} added to cart", productId);
        return "redirect:/cart";
//        return "redirect:forward:/PRODUCT_ADDED.html";
    }
    @PostMapping("/remove")
    public String removeProduct( @RequestParam Long productId,HttpServletRequest request) {
        this.cartService.deleteProductFromCart(request.getRequestedSessionId(),productId);
        logger.info("Product with ID {} removed from cart", productId);
        return "redirect:/cart";
        //return "redirect:forward:/PRODUCT_REMOVED.html";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long productId, HttpServletRequest request ) {
        this.cartService.trashProductFromCart(request.getRequestedSessionId(),productId);
        logger.info("Product with ID {} deleted from cart", productId);
        return "redirect:/cart";
        //return "redirect:forward:/PRODUCT_DELETE.html";
    }

    // zwiększenie quantity dla obiektu z listy koszyka
    // zmniejszenie quantity dla obiektu z listy koszyka

    // wyślij zamówienie???
}
