package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Category;
import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByCpf(String cpf);
    List<Employee> findByProjects(Project project);
    List<Employee> findByCategory(Category category);
    List<Employee> findEmployeeByProjectsIsNullOrProjectsIsNot(Project project);
}
