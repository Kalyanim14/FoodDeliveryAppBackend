package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.FoodOrder;

import java.util.List;

public interface OrderService {

    FoodOrder placeOrder(Long userId);


    FoodOrder getOrderById(Long orderId);
    
    List<FoodOrder> getOrdersByUser(Long userId);

    FoodOrder updateOrderStatus(
            Long orderId,
            String status);

    void deleteOrder(Long orderId);


}