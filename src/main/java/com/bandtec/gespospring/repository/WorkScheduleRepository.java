package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Integer> {
}
