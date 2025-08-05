package com.cognizant.loan;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public String getLoanDetails(@PathVariable String number) {
        return "Loan details for: " + number;
    }
}
