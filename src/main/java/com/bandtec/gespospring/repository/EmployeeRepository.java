package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Category;
import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.DTO.EmployeeLoginDTO;
import com.bandtec.gespospring.entity.table.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByCpf(String cpf);
    @Query("select new com.bandtec.gespospring.DTO.EmployeeLoginDTO(a) from Employee a where a.cpf = ?1")
    EmployeeLoginDTO findByCpdScoped(String cpf);
    List<Employee> findByProjects(Project project);
    List<Employee> findByCategory(Category category);
    List<Employee> findDistinctByProjectsIsNot(Project project);
}
