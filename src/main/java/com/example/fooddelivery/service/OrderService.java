package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.FoodOrder;

import java.util.List;

public interface OrderService {

    FoodOrder placeOrder(Long userId);

    List<FoodOrder> getOrdersByUser(Long userId);
}