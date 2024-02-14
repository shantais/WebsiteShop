package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.*;
import com.bestbuykamps.websiteshop.data_model.CartItemRepository;
import com.bestbuykamps.websiteshop.data_model.CartRepository;
import com.bestbuykamps.websiteshop.data_model.ProductRepository;
import com.bestbuykamps.websiteshop.web_controller.CheckoutController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    private final CartItemRepository cartItemRepository;
    private static final Logger log = LoggerFactory.getLogger(CartService.class);

    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);


    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }


    public void addProductToCart(Long productId, Long cartId) {
        log.info("Adding product with ID {} to the cart.", productId);
        //odpytanie czy koszyk istnieje
        //jak nie istnieje to tworzymy koszyk i zwracamy koszyk X
        //jak istnieje to zwracamy koszyk X

        boolean match = cartRepository.getById(cartId).getCartItems() == null;
        logger.info(String.valueOf(match));
        if (!match) {
            logger.info("Jestem w ifie");
            for (CartItem cartItem : cartRepository.getById(cartId).getCartItems()) {
                logger.info("jestem w pętli");
                logger.info(cartRepository.getById(cartId).getCartItems().toString());
                if (cartItem.getProduct().getId().equals(productId)) {
                    logger.info(cartItem.toString());
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    cartItemRepository.save(cartItem);
                    logger.info(cartItem.getQuantity().toString());
                }
            }
            if(!cartRepository.getById(cartId).getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId))) {
                logger.info("dodałem któryś produkt z q:1");
                addCartItem(productId, cartId);
            }
        } else {
            logger.info("jestem w elsie");
            addCartItem(productId, cartId);
        }
    }

    public void deleteProductFromCart(Long productId, Long cartId) {
        // odpytanie czy koszyk istnieje
        // nie istnieje - ogarnać wyjątek
        // istnieje - sprawdzić czy jest klucz w mapie o wartości productId
        // jeżeli q: równe 1 , usuwamy klucz+wartość
        //jeżeli q: > 1(2,3...X) zmniejszamy q: o 1
        Optional<Cart> cart = cartRepository.findById(cartId);
        boolean match = cart.get().getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId)); // zwraca boolean czy produkt jest w koszyku
        if (match) {
            for (CartItem cartItem : cart.get().getCartItems()) {
                if (cartItem.getProduct().getId().equals(productId)) {
                    cartItem.setQuantity(cartItem.getQuantity() - 1);
                    if (cartItem.getQuantity() == 0) {
                        trashProductFromCart(cartId, cartItem.getProduct().getId());
                        break;
                    }
                    break;
                    //wyjście z forEach
                }
            }
            cartRepository.save(cart.get());
        }
    }

    public void trashProductFromCart(Long productId, Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        boolean match = cart.get().getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId)); // zwraca boolean czy produkt jest w koszyku
        if (match) {
            for (CartItem cartItem : cart.get().getCartItems()) {
                if (cartItem.getProduct().getId().equals(productId)) {
                    cart.get().deleteCartItem(cartItem);
                    break;
                }
            }
            cartRepository.save(cart.get());
        }
    }

    public List<CartItem> getCartItems(Long cartId) {
        return this.cartRepository.findById(cartId).get().getCartItems();
    }


    public double getTotalCartValue(Long cartId){
        Optional<Cart> cart = cartRepository.findById(cartId);
        double totalPrice = 0;
        for (CartItem cartItem : cart.get().getCartItems()) {
            totalPrice += (cartItem.getProduct().getPrice() * cartItem.getQuantity());
        }

        return totalPrice;
    }

    public Long getCartId(String sessionId) {
        logger.info("wlazłem do getCartId");
        Optional<Cart> cart = createCart(sessionId);
        logger.info("Current cart ID: {}", cart.get().getId().toString());
        return cart.get().getId();
    }

    public Optional<Cart> createCart (String sessionId){
        Optional<Cart> cart = findCartIdBySessionId(sessionId);
        if (cart.isEmpty()) {
            cart = Optional.of(new Cart());
            cart.get().setSessionId(sessionId);
            cart.get().setCartItems(new ArrayList<>());
            cartRepository.save(cart.get());
            cartRepository.flush();
        }
        return cart;
    }

    private Optional<Cart> findCartIdBySessionId(String sessionId) {
        boolean isCartFound = cartRepository.findAll().stream().anyMatch(cart -> cart.getSessionId().equals(sessionId));
        if(isCartFound){
            logger.info(String.valueOf(Optional.of(cartRepository.findAll().stream().findFirst().filter(cart -> cart.getSessionId().equals(sessionId)).get())));
            return Optional.of(cartRepository.findAll().stream().findFirst().filter(cart -> cart.getSessionId().equals(sessionId)).get());
        }
        logger.info("jestem pusty");
        return Optional.empty();
    }

    private void addCartItem(Long productId, Long cartId){
        CartItem cartItem = new CartItem();
        cartItem.setCart(cartRepository.getById(cartId));
        cartItem.setQuantity(1);
        cartItem.setProduct(productRepository.getById(productId));
        logger.info(cartItem.toString());
        cartItemRepository.save(cartItem);
    }
}
