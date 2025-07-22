package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Employee;

import java.util.List;

public interface EmployeeRepositoryCustom {
    List<Employee> getFilteredEmployees(String name, Boolean permanent, Integer departmentId);
}
