package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByProject_Id(Integer id);
}
