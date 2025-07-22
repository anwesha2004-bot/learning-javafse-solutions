package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping("/{number}")
    public String getAccountByNumber(@PathVariable String number) {
        return "Dummy account details for account number: " + number;
    }
}
