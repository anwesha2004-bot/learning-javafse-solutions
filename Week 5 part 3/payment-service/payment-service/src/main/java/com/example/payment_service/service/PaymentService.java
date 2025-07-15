package com.example.payment_service.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String getPaymentStatus() throws InterruptedException {
        // Simulate delay
        Thread.sleep(1000); // under 2s - will pass the time limiter
        return "Payment Successful!";
    }
}

