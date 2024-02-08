package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.business_service.ContactDetailsService;
import com.bestbuykamps.websiteshop.data_model.ContactDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final ContactDetailsService contactDetailsService;
    private final CartService cartService;

    public CheckoutController(ContactDetailsService contactDetailsService, CartService cartService) {
        this.contactDetailsService = contactDetailsService;
        this.cartService = cartService;
    }

    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @GetMapping()
    public String checkoutPage() {
        return "CHECKOUT_PAGE";
    }

    @PostMapping()
    public String processCheckout(@RequestParam String name,
                                  @RequestParam String lastName,
                                  @RequestParam String email,
                                  @RequestParam String phone,
                                  @RequestParam String address,
                                  @RequestParam String country,
                                  @RequestParam String city,
                                  @RequestParam String zip) {
        logger.info("Received checkout request with following data:");
        logger.info("Name: {}", name);
        logger.info("Last Name: {}", lastName);
        logger.info("Email: {}", email);
        logger.info("Phone: {}", phone);
        logger.info("Address: {}", address);
        logger.info("Country: {}", country);
        logger.info("City: {}", city);
        logger.info("ZIP Code: {}", zip);
        return "CHECKOUT_PAGE";
    }

}