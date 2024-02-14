package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.business_service.ProductService;
import com.bestbuykamps.websiteshop.data_model.CartItem;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class Product_Controller {

    private final ProductService productService;
    private final CartService cartService;
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    public Product_Controller(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String getProducts(Model model){
//        model.addAttribute("products", this.productService.getProducts());
//        return "PRODUCTS_PAGE";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String getProducts(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        model.addAttribute("sessionId", sessionId);
        model.addAttribute("products", this.productService.getProducts());

        return "PRODUCTS_PAGE";
    }

   @GetMapping("/cart")
    public String showCartPage(Model model , HttpServletRequest request) {
       model.addAttribute("cartItems", this.cartService.getCartItems(request.getRequestedSessionId()));
       model.addAttribute("totalCartValue", cartService.getTotalCartValue(request.getRequestedSessionId()));
       return "CART_PAGE";
   }

    @PostMapping()
    public String addProductToCart(@RequestParam Long productId, HttpServletRequest request) {

        cartService.addProductToCart( request.getRequestedSessionId(),productId);
        logger.info("request{} " , request.getSession().toString());
//        logger.info("Product with ID {} added to cart", productId);
        return "PRODUCTS_PAGE";
//        return "redirect:forward:/PRODUCT_ADDED.html";
    }

    @GetMapping("/login")
    public String moveToLoginPage(){
        return "LOGIN_PAGE";
    }

//    @GetMapping("/images/{imageName}")
//    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
//
//        Resource imageResource = new ClassPathResource("static/images/" + imageName);
//
//        if (imageResource.exists() && imageResource.isReadable()) {
//            return ResponseEntity.ok()
//                    .contentType(MediaType.IMAGE_JPEG)
//                    .body(imageResource);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
