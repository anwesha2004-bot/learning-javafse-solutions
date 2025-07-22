package com.example.order_service.service;

import com.example.order_service.dto.OrderResponseDTO;
import com.example.order_service.entity.Order;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    // Simulated list of orders
    private static List<Order> orders = new ArrayList<>();

    static {
        orders.add(new Order(101L, 1L, "Laptop"));
        orders.add(new Order(102L, 2L, "Mobile"));
    }

    @Override
    public OrderResponseDTO getOrderWithUser(Long orderId) {
        Order order = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        // You can later call userService here to fetch user info.
        // For now, simulate a User:
        User user = new User(order.getUserId(), "Dummy Name", "dummy@example.com");

        return new OrderResponseDTO(order.getOrderId(), order.getProductName(), user);
    }
}


