package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.Cart;

import java.util.List;

public interface CartService {

    Cart addToCart(Long userId,
                   Long foodItemId,
                   Integer quantity);

    List<Cart> getUserCart(Long userId);

    void removeFromCart(Long cartId);
}