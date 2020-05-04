package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
