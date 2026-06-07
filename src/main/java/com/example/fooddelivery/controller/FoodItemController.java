package com.example.fooddelivery.controller;

import com.example.fooddelivery.entity.FoodItem;
import com.example.fooddelivery.service.FoodItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fooditems")
@CrossOrigin(origins = "http://localhost:5173")
public class FoodItemController {

    private final FoodItemService service;

    public FoodItemController(
            FoodItemService service) {
        this.service = service;
    }

    @PostMapping("/restaurant/{restaurantId}")
    public FoodItem addFoodItem(
            @PathVariable Long restaurantId,
            @RequestBody FoodItem foodItem) {

        return service.addFoodItem(
                restaurantId,
                foodItem);
    }

    @GetMapping
    public List<FoodItem> getAllFoodItems() {
        return service.getAllFoodItems();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<FoodItem> getFoodItemsByRestaurant(
            @PathVariable Long restaurantId) {

        return service.getFoodItemsByRestaurant(
                restaurantId);
    }

    @PutMapping("/{id}")
    public FoodItem updateFoodItem(
            @PathVariable Long id,
            @RequestBody FoodItem foodItem) {

        return service.updateFoodItem(id,
                foodItem);
    }

    @DeleteMapping("/{id}")
    public String deleteFoodItem(
            @PathVariable Long id) {

        service.deleteFoodItem(id);
        return "Food item deleted";
    }
}