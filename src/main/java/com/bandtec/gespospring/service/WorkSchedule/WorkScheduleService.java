package com.bandtec.gespospring.service.WorkSchedule;

import com.bandtec.gespospring.DTO.update.WorkScheduleUpdateDTO;
import com.bandtec.gespospring.entity.table.WorkSchedule;
import com.bandtec.gespospring.DTO.WorkScheduleDTO;

import java.util.List;

public interface WorkScheduleService {
    void save(List<WorkSchedule> workSchedules);
    WorkSchedule findById(Integer id);
    Boolean update(WorkScheduleUpdateDTO workSchedule);
    Boolean delete(Integer id);
    List<WorkScheduleDTO> findByEmployee(Integer id);
    List<WorkScheduleDTO> findByFilter(WorkSchedule workSchedule);
}
