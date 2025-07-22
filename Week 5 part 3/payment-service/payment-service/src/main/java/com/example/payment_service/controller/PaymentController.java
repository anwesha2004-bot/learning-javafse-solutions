package com.example.payment_service.controller;

import com.example.payment_service.service.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/status")
    @CircuitBreaker(name = "paymentCB", fallbackMethod = "paymentFallback")
    @TimeLimiter(name = "paymentCB")
    public CompletableFuture<String> getPaymentStatus() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return paymentService.getPaymentStatus();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public CompletableFuture<String> paymentFallback(Throwable t) {
        return CompletableFuture.completedFuture("Payment Service is temporarily unavailable. Please try again later.");
    }
}


