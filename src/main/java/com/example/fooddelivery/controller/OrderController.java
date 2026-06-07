package com.example.fooddelivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddelivery.entity.FoodOrder;
import com.example.fooddelivery.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    private final OrderService service;

    public OrderController(
            OrderService service) {

        this.service = service;
    }

    @PostMapping("/{userId}")
    public FoodOrder placeOrder(
            @PathVariable Long userId){

        return service.placeOrder(userId);
    }

    @GetMapping("/{userId}")
    public List<FoodOrder> getOrders(
            @PathVariable Long userId){

        return service.getOrdersByUser(
                userId);
    }
}