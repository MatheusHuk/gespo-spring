package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByCpf(String cpf);

    @Query("select new com.bandtec.gespospring.model.EmployeeModel(a) from Employee a where a.cpf = ?1")
    EmployeeModel findByCpfEscoped(String cpf);
}
