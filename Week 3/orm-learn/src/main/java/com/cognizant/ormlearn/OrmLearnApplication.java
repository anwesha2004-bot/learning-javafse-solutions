package com.cognizant.ormlearn;

import com.cognizant.ormlearn.entity.Employee;
import com.cognizant.ormlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Run all hands-on exercises here:
        testGetAllPermanentEmployees();      // Hands-on 2
        testGetAverageSalary();              // Hands-on 4
        testGetAllEmployeesNative();         // Hands-on 5
        testCriteriaQuery();                 // Hands-on 6
    }

    // Hands-on 2: Get all permanent employees with department and skills
    private void testGetAllPermanentEmployees() {
        LOGGER.info("Start - testGetAllPermanentEmployees");

        List<Employee> employees = employeeService.getAllPermanentEmployees();
        employees.forEach(emp -> {
            LOGGER.debug("Employee: {}", emp);
            LOGGER.debug("Department: {}", emp.getDepartment());
            LOGGER.debug("Skills: {}", emp.getSkillList());
        });

        LOGGER.info("End - testGetAllPermanentEmployees");
    }

    // Hands-on 4: Get average salary of a department
    private void testGetAverageSalary() {
        LOGGER.info("Start - testGetAverageSalary");

        int departmentId = 1; // change this to match your DB data
        double avgSalary = employeeService.getAverageSalary(departmentId);
        LOGGER.debug("Average Salary for Department {}: {}", departmentId, avgSalary);

        LOGGER.info("End - testGetAverageSalary");
    }

    // Hands-on 5: Get all employees using native query
    private void testGetAllEmployeesNative() {
        LOGGER.info("Start - testGetAllEmployeesNative");

        List<Employee> employees = employeeService.getAllEmployeesNative();
        employees.forEach(emp -> LOGGER.debug("Employee (Native): {}", emp));

        LOGGER.info("End - testGetAllEmployeesNative");
    }

    // Hands-on 6: Use criteria query to filter employees dynamically
    private void testCriteriaQuery() {
        LOGGER.info("Start - testCriteriaQuery");

        String name = "Jo";         // optional, set to null if not filtering
        Boolean permanent = true;   // optional, set to null if not filtering
        Integer departmentId = 2;   // optional, set to null if not filtering

        List<Employee> filteredEmployees = employeeService.getFilteredEmployees(name, permanent, departmentId);
        filteredEmployees.forEach(emp -> LOGGER.debug("Filtered Employee: {}", emp));

        LOGGER.info("End - testCriteriaQuery");
    }
}



