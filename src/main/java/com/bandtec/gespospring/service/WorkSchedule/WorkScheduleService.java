package com.bandtec.gespospring.service.WorkSchedule;

import com.bandtec.gespospring.entity.table.WorkSchedule;
import com.bandtec.gespospring.model.WorkScheduleModel;

import java.util.List;

public interface WorkScheduleService {
    void save(List<WorkSchedule> workSchedules);
    WorkSchedule findById(Integer id);
    Boolean update(WorkSchedule workSchedule);
    Boolean delete(Integer id);
    List<WorkScheduleModel> findByEmployee(Integer id);
    List<WorkScheduleModel> findByFilter(WorkSchedule workSchedule);
}
