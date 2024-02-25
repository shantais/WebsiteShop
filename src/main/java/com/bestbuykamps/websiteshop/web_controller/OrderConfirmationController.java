package com.bestbuykamps.websiteshop.web_controller;
import com.bestbuykamps.websiteshop.data_model.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Controller
@RequestMapping("/")
public class OrderConfirmationController {
private final OrderRepository orderRepository;

    public OrderConfirmationController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //TODO: sprawdzić czy potrzebne przerobić na redirect do strony głównej
    @GetMapping("confirmation")
    public String showOrderConfirmation(Model model) {
        Random random = new Random();
        int orderNumber = random.nextInt(1000000);
        model.addAttribute("orderNumber", orderNumber);
        return "ORDER_PLACED";
    }
}