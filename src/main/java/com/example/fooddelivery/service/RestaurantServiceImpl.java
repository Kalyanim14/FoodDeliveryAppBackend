package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.Restaurant;
import com.example.fooddelivery.repository.RestaurantRepository;
import com.example.fooddelivery.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl
        implements RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantServiceImpl(
            RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant addRestaurant(
            Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Restaurant not found"));
    }

    @Override
    public Restaurant updateRestaurant(
            Long id,
            Restaurant restaurant) {

        Restaurant existing =
                getRestaurantById(id);

        existing.setName(restaurant.getName());
        existing.setAddress(restaurant.getAddress());
        existing.setPhone(restaurant.getPhone());

        return repository.save(existing);
    }

    @Override
    public void deleteRestaurant(Long id) {
        repository.deleteById(id);
    }
}