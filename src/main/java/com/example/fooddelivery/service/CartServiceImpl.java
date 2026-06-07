package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.*;

import com.example.fooddelivery.repository.*;

import com.example.fooddelivery.service.CartService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl
        implements CartService {

    private final CartRepository cartRepo;
    private final UserRepository userRepo;
    private final FoodItemRepository foodRepo;

    public CartServiceImpl(
            CartRepository cartRepo,
            UserRepository userRepo,
            FoodItemRepository foodRepo) {

        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
        this.foodRepo = foodRepo;
    }

    @Override
    public Cart addToCart(Long userId,
                          Long foodItemId,
                          Integer quantity) {

        User user =
                userRepo.findById(userId)
                        .orElseThrow();

        FoodItem foodItem =
                foodRepo.findById(foodItemId)
                        .orElseThrow();

        Cart cart = new Cart();

        cart.setUser(user);
        cart.setFoodItem(foodItem);
        cart.setQuantity(quantity);

        return cartRepo.save(cart);
    }

    @Override
    public List<Cart> getUserCart(
            Long userId) {

        return cartRepo.findByUserId(userId);
    }

    @Override
    public void removeFromCart(
            Long cartId) {

        cartRepo.deleteById(cartId);
    }
}