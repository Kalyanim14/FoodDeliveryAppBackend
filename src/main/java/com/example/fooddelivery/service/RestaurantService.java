package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(Long id);

    Restaurant updateRestaurant(Long id,
                                Restaurant restaurant);

    void deleteRestaurant(Long id);
}