package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OrdersService {

    // TODO: userRepo jeszcze nie wykorzystane
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    private final CartService cartService;
    @Autowired
    public OrdersService(CartRepository cartRepository, UserRepository userRepository, OrderRepository orderRepository, CartService cartService) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.cartService = cartService;
    }

    public void createNewOrder(String sessionId){
        Orders orders = new Orders();
        orders.setCartId(cartService.getCartIdBySessionId(sessionId));
        orders.setUserId(null); // obecna opcja dla niezalogowanego użytkownika
        orders.setSessionId(sessionId);
        orders.setOrderNumber(generateNewOrderNumber());
        orderRepository.save(orders);
        String orderPlaced = "Order Placed";
        cartService.getCart(sessionId).setSessionId(orderPlaced);
        cartRepository.save(cartRepository.getReferenceById(cartService.getCartId(orderPlaced)));

    //TODO czyszczenie sessionID z koszyka

    }

    public Orders getOrder(String sessionId) {
        List<Orders> orders = orderRepository.findAll();
        for (Orders order : orders) {
            if (order.getSessionId().equals(sessionId)) {
                return order;
            }
        }
        return new Orders();
    }

    public Long generateNewOrderNumber(){
        Random random = new Random();
        Long orderNumber = random.nextLong(1000000);
        return orderNumber;
    }


}
