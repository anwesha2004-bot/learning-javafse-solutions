package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getFilteredEmployees(String name, Boolean permanent, Integer departmentId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> emp = cq.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            predicates.add(cb.like(emp.get("name"), "%" + name + "%"));
        }
        if (permanent != null) {
            predicates.add(cb.equal(emp.get("permanent"), permanent));
        }
        if (departmentId != null) {
            predicates.add(cb.equal(emp.get("department").get("id"), departmentId));
        }

        cq.select(emp).where(cb.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(cq).getResultList();
    }
}


