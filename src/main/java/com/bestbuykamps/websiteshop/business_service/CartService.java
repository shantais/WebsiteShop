package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.*;
import com.bestbuykamps.websiteshop.data_model.CartItemRepository;
import com.bestbuykamps.websiteshop.data_model.CartRepository;
import com.bestbuykamps.websiteshop.data_model.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    private final CartItemRepository cartItemRepository;
    private static final Logger log = LoggerFactory.getLogger(CartService.class);


    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }


    public void addProductToCart(Long productId) {
        log.info("Adding product with ID {} to the cart.", productId);
        //odpytanie czy koszyk istnieje
        //jak nie istnieje to tworzymy koszyk i zwracamy koszyk X
        //jak istnieje to zwracamy koszyk X

        Optional<Cart> cart = cartRepository.findById(1L);
        boolean match = cart.get().getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId)); // zwraca boolean czy produkt jest w koszyku
        if (match) {
            for (CartItem cartItem : cart.get().getCartItems()) {
                if (cartItem.getProduct().getId().equals(productId)) {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                }
            }
            cartRepository.save(cart.get());
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart.get());
            cartItem.setQuantity(1);
            cartItem.setProduct(productRepository.getById(productId));
            cart.get().addCartItem(cartItem);
            cartRepository.save(cart.get());
        }


        // do zrobienia - dodać cart map do carta
        // sprawdzić czy jest klucz o wartości productID
        // jest , zwiększyć wartość o 1
        // nie ma , dodać nowy klucz i ustawić wartość na 1

        // przy dodaniu sprawdzać czy w magazynie starczy produktów po dodaniu
    }

    public void deleteProductFromCart(Long cartID ,Long productId) {
        // odpytanie czy koszyk istnieje
        // nie istnieje - ogarnać wyjątek
        // istnieje - sprawdzić czy jest klucz w mapie o wartości productId
        // jeżeli q: równe 1 , usuwamy klucz+wartość
        //jeżeli q: > 1(2,3...X) zmniejszamy q: o 1
        Optional<Cart> cart = cartRepository.findById(cartID);
        boolean match = cart.get().getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId)); // zwraca boolean czy produkt jest w koszyku
        if (match) {
            for (CartItem cartItem : cart.get().getCartItems()) {
                if (cartItem.getProduct().getId().equals(productId)) {
                    cartItem.setQuantity(cartItem.getQuantity() - 1);
                    if(cartItem.getQuantity() == 0){
                        trashProductFromCart(cartID,cartItem.getProduct().getId());
                        break;
                    }
                    break;
                }
            }
            cartRepository.save(cart.get());
        }
    }

    public void trashProductFromCart(Long cartID ,Long productId) {
        Optional<Cart> cart = cartRepository.findById(cartID);
        boolean match = cart.get().getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId)); // zwraca boolean czy produkt jest w koszyku
        if (match) {
            for (CartItem cartItem : cart.get().getCartItems()) {
                if (cartItem.getProduct().getId().equals(productId)) {
                        cart.get().deleteCartItem(cartItem);
                }
            }
            cartRepository.save(cart.get());
        }
    }

    public List<CartItem> getCartItems(Long cartId) {
        return this.cartRepository.findById(cartId).get().getCartItems();
    }
}
