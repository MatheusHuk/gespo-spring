package com.bandtec.gespospring.service.WorkSchedule;

import com.bandtec.gespospring.DTO.request.WorkScheduleUpdateDTO;
import com.bandtec.gespospring.entity.table.WorkSchedule;

import java.util.List;

public interface WorkScheduleService {
    void save(List<WorkSchedule> workSchedules);
    WorkSchedule findById(Integer id);
    Boolean update(WorkScheduleUpdateDTO workSchedule);
    Boolean delete(Integer id);
    List<WorkSchedule> findByEmployee(Integer id);
    List<WorkSchedule> findByFilter(WorkSchedule workSchedule);
}
