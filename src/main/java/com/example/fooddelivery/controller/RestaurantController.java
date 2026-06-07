package com.example.fooddelivery.controller;

import com.example.fooddelivery.entity.Restaurant;
import com.example.fooddelivery.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin(origins = "http://localhost:5173")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(
            RestaurantService service) {
        this.service = service;
    }

    @PostMapping
    public Restaurant addRestaurant(
            @RequestBody Restaurant restaurant) {

        return service.addRestaurant(restaurant);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {

        return service.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(
            @PathVariable Long id) {

        return service.getRestaurantById(id);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(
            @PathVariable Long id,
            @RequestBody Restaurant restaurant) {

        return service.updateRestaurant(id,
                restaurant);
    }

    @DeleteMapping("/{id}")
    public String deleteRestaurant(
            @PathVariable Long id) {

        service.deleteRestaurant(id);
        return "Restaurant deleted successfully";
    }
}