package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.FoodItem;

import java.util.List;

public interface FoodItemService {

    FoodItem addFoodItem(Long restaurantId,
                         FoodItem foodItem);

    List<FoodItem> getAllFoodItems();

    List<FoodItem> getFoodItemsByRestaurant(
            Long restaurantId);

    FoodItem updateFoodItem(Long id,
                            FoodItem foodItem);

    void deleteFoodItem(Long id);
}