package com.example.fooddelivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddelivery.entity.FoodOrder;
import com.example.fooddelivery.service.OrderService;

@RestController
@RequestMapping("/api/orders")
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
  
    @GetMapping("/single/{orderId}")
    public FoodOrder getOrderById(
            @PathVariable Long orderId){

        return service.getOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    public FoodOrder updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam String status){

        return service.updateOrderStatus(
                orderId,
                status);
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(
            @PathVariable Long orderId){

        service.deleteOrder(orderId);

        return "Order deleted successfully";
    }
 

}