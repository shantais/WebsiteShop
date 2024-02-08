package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.business_service.ProductService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class Product_Controller {

    private final ProductService productService;
    private final CartService cartService;

    public Product_Controller(ProductService productService, CartService cartService) {
        this.productService = productService;

        this.cartService = cartService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getProducts(Model model){
        model.addAttribute("products", this.productService.getProducts());
        return "PRODUCTS_PAGE";
    }
   @GetMapping("/cart")
    public String showCartPage(Model model) {
       model.addAttribute("cartItems", this.cartService.getCartItems(1L));
       return "CART_PAGE";
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
