package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.FoodItem;
import com.example.fooddelivery.entity.Restaurant;
import com.example.fooddelivery.repository.FoodItemRepository;
import com.example.fooddelivery.repository.RestaurantRepository;
import com.example.fooddelivery.service.FoodItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemServiceImpl
        implements FoodItemService {

    private final FoodItemRepository foodRepo;
    private final RestaurantRepository restaurantRepo;

    public FoodItemServiceImpl(
            FoodItemRepository foodRepo,
            RestaurantRepository restaurantRepo) {

        this.foodRepo = foodRepo;
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public FoodItem addFoodItem(Long restaurantId,
                                FoodItem foodItem) {

        Restaurant restaurant =
                restaurantRepo.findById(restaurantId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restaurant not found"));

        foodItem.setRestaurant(restaurant);

        return foodRepo.save(foodItem);
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return foodRepo.findAll();
    }

    @Override
    public List<FoodItem> getFoodItemsByRestaurant(
            Long restaurantId) {

        return foodRepo.findByRestaurantId(
                restaurantId);
    }

    @Override
    public FoodItem updateFoodItem(Long id,
                                   FoodItem foodItem) {

        FoodItem existing =
                foodRepo.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Food item not found"));

        existing.setName(foodItem.getName());
        existing.setPrice(foodItem.getPrice());
        existing.setDescription(
                foodItem.getDescription());

        return foodRepo.save(existing);
    }

    @Override
    public void deleteFoodItem(Long id) {
        foodRepo.deleteById(id);
    }
}