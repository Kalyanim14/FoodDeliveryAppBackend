package com.example.fooddelivery.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Cart;
import com.example.fooddelivery.entity.FoodOrder;
import com.example.fooddelivery.entity.OrderItem;
import com.example.fooddelivery.entity.User;
import com.example.fooddelivery.repository.CartRepository;
import com.example.fooddelivery.repository.FoodOrderRepository;
import com.example.fooddelivery.repository.OrderItemRepository;
import com.example.fooddelivery.repository.UserRepository;

@Service
public class OrderServiceImpl
        implements OrderService {

    private final UserRepository userRepo;
    private final CartRepository cartRepo;
    private final FoodOrderRepository orderRepo;
    private final OrderItemRepository orderItemRepo;

    public OrderServiceImpl(
            UserRepository userRepo,
            CartRepository cartRepo,
            FoodOrderRepository orderRepo,
            OrderItemRepository orderItemRepo) {

        this.userRepo = userRepo;
        this.cartRepo = cartRepo;
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
    }

    @Override
    public FoodOrder placeOrder(Long userId) {

        User user =
                userRepo.findById(userId)
                        .orElseThrow();

        List<Cart> cartItems =
                cartRepo.findByUserId(userId);

        if(cartItems.isEmpty()) {
            throw new RuntimeException(
                    "Cart is empty");
        }

        double total = 0;

        FoodOrder order = new FoodOrder();

        order.setUser(user);
        order.setStatus("PLACED");
        order.setOrderDate(
                LocalDateTime.now());

        order = orderRepo.save(order);

        		List<OrderItem> orderItems =
        		        new ArrayList<>();

        		for(Cart cart : cartItems){

        		    OrderItem item =
        		            new OrderItem();

        		    item.setFoodOrder(order);

        		    item.setFoodItem(
        		            cart.getFoodItem());

        		    item.setQuantity(
        		            cart.getQuantity());

        		    item.setPrice(
        		            cart.getFoodItem()
        		            .getPrice());

        		    total += item.getPrice()
        		            * item.getQuantity();

        		    orderItems.add(item);

        		    orderItemRepo.save(item);
        		}

        		order.setOrderItems(orderItems);

        order.setTotalAmount(total);

        orderRepo.save(order);

        cartRepo.deleteAll(cartItems);

        return order;
    }

    @Override
    public List<FoodOrder> getOrdersByUser(
            Long userId) {

        return orderRepo.findByUserId(
                userId);
    }

    public FoodOrder updateOrderStatus(Long orderId, String status) {

        FoodOrder order =
                orderRepo.findById(orderId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Order not found"));

        order.setStatus(status);

        return orderRepo.save(order);
    }

    public void deleteOrder(Long orderId) {

        orderRepo.deleteById(orderId);
    }

    public FoodOrder getOrderById(Long orderId) {

        return orderRepo.findById(orderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Order not found"));
    }


}