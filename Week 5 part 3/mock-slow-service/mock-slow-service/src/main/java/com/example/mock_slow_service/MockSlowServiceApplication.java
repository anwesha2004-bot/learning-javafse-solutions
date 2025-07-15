package com.example.mock_slow_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class MockSlowServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockSlowServiceApplication.class, args);
	}

	@GetMapping("/slow-api")
	public String slowApi() throws InterruptedException {
		Thread.sleep(4000); // Simulate delay (4 seconds)
		return "✅ Payment Processed by Slow API!";
	}
}
