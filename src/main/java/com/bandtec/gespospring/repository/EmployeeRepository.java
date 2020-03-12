package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
}
