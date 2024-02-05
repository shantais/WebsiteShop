package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.CartItemRepository;
import com.bestbuykamps.websiteshop.data_model.CartRepository;
import com.bestbuykamps.websiteshop.data_model.Product;
import com.bestbuykamps.websiteshop.data_model.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;



    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


    public void addProductToCart(Long productId) {
        //odpytanie czy koszyk istnieje
        //jak nie istnieje to tworzymy koszyk i zwracamy koszyk X
        //jak istnieje to zwracamy koszyk X

        // do zrobienia - dodać cart map do carta
        // sprawdzić czy jest klucz o wartości productID
        // jest , zwiększyć wartość o 1
        // nie ma , dodać nowy klucz i ustawić wartość na 1

        // przy dodaniu sprawdzać czy w magazynie starczy produktów po dodaniu
    }

    public void deleteProductFromCart(Long productId) {
        // odpytanie czy koszyk istnieje
        // nie istnieje - ogarnać wyjątek
        // istnieje - sprawdzić czy jest klucz w mapie o wartości productId
        // jeżeli q: równe 1 , usuwamy klucz+wartość
        //jeżeli q: > 1(2,3...X) zmniejszamy q: o 1

    }
}
