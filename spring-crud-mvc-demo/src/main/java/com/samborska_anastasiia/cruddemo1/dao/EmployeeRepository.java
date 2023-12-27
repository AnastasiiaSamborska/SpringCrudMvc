package com.samborska_anastasiia.cruddemo1.dao;

import com.samborska_anastasiia.cruddemo1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
