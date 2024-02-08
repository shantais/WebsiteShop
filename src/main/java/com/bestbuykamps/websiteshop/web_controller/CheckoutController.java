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

    @PostMapping("")
    public String processCheckout(@RequestBody ContactDetails contactDetails) {
        logger.info("Received checkout request with following data:");
        logger.info("Name: {}", contactDetails.getFirstName());
        logger.info("Last Name: {}", contactDetails.getLastName());
        logger.info("Email: {}", contactDetails.getEmail());
        logger.info("Phone: {}", contactDetails.getPhoneNumber());
        logger.info("Address: {}", contactDetails.getStreet());
        logger.info("Country: {}", contactDetails.getCountry());
        logger.info("City: {}", contactDetails.getCity());
        logger.info("ZIP Code: {}", contactDetails.getPostalCode());
        logger.info("Cart: {}", contactDetails.getCart().getId());
        return "CHECKOUT_PAGE";
    }

}