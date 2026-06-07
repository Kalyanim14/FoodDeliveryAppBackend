package com.example.fooddelivery.controller;

import com.example.fooddelivery.entity.Cart;
import com.example.fooddelivery.service.CartService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173")
public class CartController {

    private final CartService service;

    public CartController(
            CartService service) {

        this.service = service;
    }

    @PostMapping
    public Cart addToCart(
            @RequestParam Long userId,
            @RequestParam Long foodItemId,
            @RequestParam Integer quantity) {

        return service.addToCart(
                userId,
                foodItemId,
                quantity);
    }

    @GetMapping("/{userId}")
    public List<Cart> getUserCart(
            @PathVariable Long userId) {

        return service.getUserCart(userId);
    }

    @DeleteMapping("/{cartId}")
    public String remove(
            @PathVariable Long cartId) {

        service.removeFromCart(cartId);

        return "Item removed";
    }
}