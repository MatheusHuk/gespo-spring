package com.bandtec.gespospring.service;


import com.bandtec.gespospring.entity.WorkSchedule;

import java.util.List;


public interface WorkScheduleService {
    void save(List<WorkSchedule> workSchedules);
    WorkSchedule findById(Integer id);
    Boolean update(WorkSchedule workSchedule);
    Boolean delete(Integer id);
    List<WorkSchedule> findByEmployee(Integer id);
}
