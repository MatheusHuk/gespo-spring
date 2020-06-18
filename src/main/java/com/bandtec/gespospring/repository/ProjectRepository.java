package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByEmployees(Employee employee);
}
