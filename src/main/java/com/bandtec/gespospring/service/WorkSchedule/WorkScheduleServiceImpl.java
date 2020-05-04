package com.bandtec.gespospring.service.WorkSchedule;

import com.bandtec.gespospring.entity.table.WorkSchedule;
import com.bandtec.gespospring.model.WorkScheduleModel;
import com.bandtec.gespospring.repository.WorkScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class WorkScheduleServiceImpl implements WorkScheduleService {

    @Autowired
    private WorkScheduleRepository workScheduleRepository;

    @Override
    public void save(List<WorkSchedule> workSchedules) {
        workScheduleRepository.saveAll(workSchedules);
    }

    @Override
    public WorkSchedule findById(Integer id) {
        return workScheduleRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Boolean update(WorkSchedule workSchedule) {
        return workScheduleRepository.findById(workSchedule.getId()).map( wks -> {
            wks.setAmountHours(workSchedule.getAmountHours());
            wks.setDsWork(workSchedule.getDsWork());
            wks.setEmployee(workSchedule.getEmployee());
            wks.setProject(workSchedule.getProject());
            workScheduleRepository.save(wks);

            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer id) {
        return workScheduleRepository.findById(id).map( wks -> {
            workScheduleRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public List<WorkScheduleModel> findByEmployee(Integer id) {
        return workScheduleRepository.findByEmployeeId(id);
    }
}
