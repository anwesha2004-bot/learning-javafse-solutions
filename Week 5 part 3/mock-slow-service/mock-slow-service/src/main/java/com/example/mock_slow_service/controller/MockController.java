package com.example.mock_slow_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    @GetMapping("/mock/slow")
    public String slowMock() throws InterruptedException {
        Thread.sleep(5000); // simulate slow response
        return "Slow response from mock service";
    }
}

