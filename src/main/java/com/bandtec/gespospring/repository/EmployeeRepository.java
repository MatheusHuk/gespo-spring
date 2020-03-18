package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
