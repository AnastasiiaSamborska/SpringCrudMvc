package com.samborska_anastasiia.cruddemo1.dao;

import com.samborska_anastasiia.cruddemo1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();

}
