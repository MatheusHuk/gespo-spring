package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Integer> {
    List<WorkSchedule> findByEmployee_Id(Integer id);
}
