package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByPasswordAndCpf(String password, String cpf);
//
//    Employee findByPassword(String password);

    Employee findByCpf(String cpf);
}
