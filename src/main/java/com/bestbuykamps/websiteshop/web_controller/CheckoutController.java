package com.bestbuykamps.websiteshop.web_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {
    @GetMapping("/checkout")
    public String checkoutPage() {
        return "CHECKOUT_PAGE";
    }
}