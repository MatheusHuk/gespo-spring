package com.bandtec.gespospring.service.WorkSchedule;

import com.bandtec.gespospring.DTO.update.WorkScheduleUpdateDTO;
import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.entity.table.WorkSchedule;
import com.bandtec.gespospring.DTO.WorkScheduleDTO;
import com.bandtec.gespospring.repository.WorkScheduleRepository;
import com.bandtec.gespospring.service.Project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class WorkScheduleServiceImpl implements WorkScheduleService {

    @Autowired
    private WorkScheduleRepository workScheduleRepository;

    @Autowired
    private ProjectService projectService;

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
    public Boolean update(WorkScheduleUpdateDTO workSchedule) {
        Project project = projectService.findById(workSchedule.getProject().getId());

        return workScheduleRepository.findById(workSchedule.getId()).map( wks -> {
            wks.setAmountHours(workSchedule.getAmountHours());
            wks.setDsWork(workSchedule.getDsWork());
            wks.setProject(project);
            wks.setCreationDate(workSchedule.getCreationDate());
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
    public List<WorkScheduleDTO> findByEmployee(Integer id) {
        return workScheduleRepository.findByEmployeeId(id);
    }

    @Override
    public List<WorkScheduleDTO> findByFilter(WorkSchedule workSchedule) {
        List<WorkSchedule> workScheduleList = workScheduleRepository.findAll(Example.of(workSchedule));
        List<WorkScheduleDTO> workScheduleDTO = new ArrayList<>();

        if (workScheduleList.isEmpty()) {
            return workScheduleDTO;
        }

        for (WorkSchedule wor :
                workScheduleList) {
            workScheduleDTO.add(new WorkScheduleDTO(wor));
        }

        return workScheduleDTO;
    }
}
