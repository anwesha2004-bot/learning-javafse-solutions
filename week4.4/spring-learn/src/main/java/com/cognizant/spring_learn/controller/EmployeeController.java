package com.cognizant.spring_learn.controller;


import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        LOGGER.info("START - getAllEmployees");
        List<Employee> list = employeeService.getAllEmployees();
        LOGGER.debug("Employees: {}", list);
        LOGGER.info("END - getAllEmployees");
        return list;
    }
}
