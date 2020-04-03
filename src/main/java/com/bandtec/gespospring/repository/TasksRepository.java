package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks, Integer> {
}
