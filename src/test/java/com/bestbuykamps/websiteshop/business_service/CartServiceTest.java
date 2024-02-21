package com.bestbuykamps.websiteshop.business_service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.bestbuykamps.websiteshop.data_model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CartServiceTest {
    @Mock
    private CartRepository cartRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private CartItemRepository cartItemRepository;
    @InjectMocks
    private CartService cartService;
    private String sessionId;
    private Long productId;
    private Long cartId;

 /*   @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cartService = new CartService(cartRepository, productRepository, cartItemRepository);
        sessionId = "sessionId";
        productId = 1L;
        cartId = 1L;
        Cart cart = createCart();
        when(cartService.getCartIdBySessionId(sessionId)).thenReturn(cart.getId());
        when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));
    }*/

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

   /* @Test
    public void testFindAllProducts() {
        Discount discount = new Discount("PERCENT", 10.0);
        Product product1 = new Product("Call of duty Modern Warfare 3", "Gry Komputerowe", 59.99, discount, "/images/callofduty.jpg");
        Product product2 = new Product("Cyberpunk 2077", "Gry Komputerowe", 49.99, discount, "/images/Cyberpunk_2077.jpeg");

        List<Product> expectedProducts = Arrays.asList(product1, product2);
    }*/

    @Test
    public void whenDeleteProductFromCart_thenProductIsRemovedAndCartSaved() {
        Cart cart = cartRepository.findById(cartId).get();
        cartService.deleteProductFromCart(sessionId, productId);

        verify(cartRepository, times(1)).save(cart);
        assertFalse(cart.getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId)));
    }

    private Cart createCart() {
        Cart cart = new Cart();
        cart.setId(cartId);
        cart.setSessionId(sessionId);
        CartItem cartItem = new CartItem();
        cartItem.setId(1L);
        cartItem.setCart(cart);
        Product product = new Product();
        product.setId(productId);
        cartItem.setProduct(product);
        cart.getCartItems().add(cartItem);
        return cart;
    }
}