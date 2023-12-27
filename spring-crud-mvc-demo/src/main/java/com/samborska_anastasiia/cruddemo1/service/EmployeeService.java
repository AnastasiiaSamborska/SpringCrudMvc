package com.samborska_anastasiia.cruddemo1.service;

import com.samborska_anastasiia.cruddemo1.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
