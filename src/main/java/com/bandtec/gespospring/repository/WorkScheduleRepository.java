package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.WorkSchedule;
import com.bandtec.gespospring.model.WorkScheduleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Integer> {

    @Query("SELECT new com.bandtec.gespospring.model.WorkScheduleModel(SCHEDULE) " +
            "FROM WorkSchedule SCHEDULE " +
            "WHERE SCHEDULE.employee.id = ?1")
    List<WorkScheduleModel> findByEmployeeId(Integer id);
}
