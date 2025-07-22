package com.example.order_service.service;

import com.example.order_service.dto.OrderResponseDTO;
import com.example.order_service.dto.UserDTO;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrderService {
    OrderResponseDTO getOrderWithUser(Long orderId);
}

    @Autowired
    private OrderRepository orderRepository;

    private final WebClient webClient;

    public OrderService(WebClient.Builder webClientBuilder) {
        // Ensure this points to the correct port where your UserService runs
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    public OrderResponseDTO getOrderWithUser(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        UserDTO user;
        try {
            user = webClient.get()
                    .uri("/users/" + order.getUserId())
                    .retrieve()
                    .bodyToMono(UserDTO.class)
                    .block(); // Blocking for simplicity
        } catch (Exception e) {
            throw new RuntimeException("Error while calling UserService: " + e.getMessage());
        }

        if (user == null) {
            throw new RuntimeException("User not found in UserService for ID: " + order.getUserId());
        }

        OrderResponseDTO response = new OrderResponseDTO();
        response.setOrderId(order.getId());
        response.setProductName(order.getProductName());
        response.setPrice(order.getPrice());
        response.setUser(user);

        return response;
    }
}
