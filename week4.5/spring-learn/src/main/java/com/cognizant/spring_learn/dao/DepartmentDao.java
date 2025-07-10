package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    private static List<Department> departmentList = new ArrayList<>();

    static {
        departmentList.add(new Department(1, "Human Resources"));
        departmentList.add(new Department(2, "Finance"));
        departmentList.add(new Department(3, "Engineering"));
        departmentList.add(new Department(4, "Marketing"));
    }

    public List<Department> getAllDepartments() {
        return departmentList;
    }

    public Department getDepartmentById(int id) {
        return departmentList.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

