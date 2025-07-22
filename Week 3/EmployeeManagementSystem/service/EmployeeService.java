package com.ems.service;

import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public Page<Employee> getPaginatedEmployees(int page, int size, String sortBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
    return employeeRepository.findAll(pageable);
}

import java.util.List;
import java.util.Optional;
public List<Employee> getEmployeesByName(String name) {
    return employeeRepository.findByName(name);
}

public List<Employee> getEmployeesByDepartmentName(String deptName) {
    return employeeRepository.findByDepartmentName(deptName);
}

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create or Update
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read All
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Read By ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Delete
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Pagination and Sorting
    public Page<Employee> getAllEmployeesPaged(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }

    // Custom Query Example (optional for next exercises)
    public List<Employee> findByNameContaining(String keyword) {
        return employeeRepository.findByNameContaining(keyword);
    }
}
