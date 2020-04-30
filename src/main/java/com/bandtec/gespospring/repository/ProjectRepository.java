package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
