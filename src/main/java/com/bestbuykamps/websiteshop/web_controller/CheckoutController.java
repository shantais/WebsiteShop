package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.business_service.ContactDetailsService;
import com.bestbuykamps.websiteshop.business_service.OrdersService;
import com.bestbuykamps.websiteshop.data_model.OrderRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final ContactDetailsService contactDetailsService;
    private final OrderRepository orderRepository;
    private final OrdersService ordersService;
    private final CartService cartService;



    public CheckoutController(ContactDetailsService contactDetailsService, OrderRepository orderRepository, OrdersService ordersService, CartService cartService) {
        this.contactDetailsService = contactDetailsService;
        this.orderRepository = orderRepository;
        this.ordersService = ordersService;
        this.cartService = cartService;
    }

    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @GetMapping()
    public String checkoutPage() {
        return "CHECKOUT_PAGE";
    }

    @PostMapping()
    public String processCheckout(Model model , HttpServletRequest request,
                                  @RequestParam String name,
                                  @RequestParam String lastName,
                                  @RequestParam String email,
                                  @RequestParam String phone,
                                  @RequestParam String address,
                                  @RequestParam String country,
                                  @RequestParam String city,
                                  @RequestParam String zip) {
        logger.info("Received checkout request with following data:");
        logger.info("session id : {}", request.getRequestedSessionId());
        logger.info("Name: {}", name);
        logger.info("Last Name: {}", lastName);
        logger.info("Email: {}", email);
        logger.info("Phone: {}", phone);
        logger.info("Address: {}", address);
        logger.info("Country: {}", country);
        logger.info("City: {}", city);
        logger.info("ZIP Code: {}", zip);

        contactDetailsService.createContactDetails(name,lastName,email,phone,address,country,city,zip , request.getRequestedSessionId());
        ordersService.createNewOrder(request.getRequestedSessionId());
        showOrderConfirmation(model , request.getRequestedSessionId());


        return "ORDER_PlACED";
    }


    public void showOrderConfirmation(Model model , String sessionId) {
        Long orderNumber = ordersService.getOrder(sessionId).getOrderNumber();
        model.addAttribute("orderNumber", orderNumber);
    }

}