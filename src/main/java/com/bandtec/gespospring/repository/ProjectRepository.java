package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.entity.view.VwSimpleProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query("Select new com.bandtec.gespospring.entity.view.VwSimpleProject(sp) from VwSimpleProject sp where sp.employeeId = ?1 ")
    Set<VwSimpleProject> findByEmployees(Integer employeeId);
}
