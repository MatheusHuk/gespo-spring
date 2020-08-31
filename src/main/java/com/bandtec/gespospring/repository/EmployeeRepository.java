package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Category;
import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByCpf(String cpf);
    List<Employee> findByProjects(Project project);
    List<Employee> findByCategory(Category category);
    List<Employee> findEmployeeByProjectsIsNullOrProjectsIsNot(Project project);

    @Query(nativeQuery = true, value = "" +
            "SELECT * FROM Employee " +
            "JOIN Office ON Employee.FK_OFFICE = Office.Id " +
            "JOIN Permission ON Office.FK_PERMISSION = Permission.Id " +
            "WHERE Permission.Id = 1 OR Permission.ID = 3;")
    List<Employee> findAllManagers();
}
