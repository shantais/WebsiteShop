package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.business_service.ContactDetailsService;
import com.bestbuykamps.websiteshop.data_model.ContactDetails;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

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

//    @PostMapping()
//    public String processCheckout(Model model ,@RequestParam String name,
//                                  @RequestParam String lastName,
//                                  @RequestParam String email,
//                                  @RequestParam String phone,
//                                  @RequestParam String address,
//                                  @RequestParam String country,
//                                  @RequestParam String city,
//                                  @RequestParam String zip) {
//        logger.info("Received checkout request with following data:");
//        logger.info("Name: {}", name);
//        logger.info("Last Name: {}", lastName);
//        logger.info("Email: {}", email);
//        logger.info("Phone: {}", phone);
//        logger.info("Address: {}", address);
//        logger.info("Country: {}", country);
//        logger.info("City: {}", city);
//        logger.info("ZIP Code: {}", zip);
//
//        showOrderConfirmation(model);
//        return "ORDER_PlACED";
//    }
@PostMapping()
public String processCheckout(Model model, @Valid @ModelAttribute("contactDetails") ContactDetails contactDetails, BindingResult result) {
    if (result.hasErrors()) {
        return "CHECKOUT_PAGE";
    }

    logger.info("Received checkout request with following data:");
    logger.info("Contact Details: {}", contactDetails);

    showOrderConfirmation(model);
    return "ORDER_PlACED";
}


    public void showOrderConfirmation(Model model) {
        Random random = new Random();
        int orderNumber = random.nextInt(1000000);
        model.addAttribute("orderNumber", orderNumber);
    }

}