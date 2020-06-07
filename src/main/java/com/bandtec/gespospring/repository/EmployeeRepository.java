package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.DTO.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByCpf(String cpf);

    @Query("select new com.bandtec.gespospring.DTO.EmployeeDTO(a) from Employee a where a.cpf = ?1")
    EmployeeDTO findByCpfEscoped(String cpf);
}
