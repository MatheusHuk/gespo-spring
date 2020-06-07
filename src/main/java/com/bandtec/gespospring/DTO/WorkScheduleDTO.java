package com.bandtec.gespospring.DTO;

import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.entity.table.WorkSchedule;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkScheduleDTO {

    private Integer id;
    private Date creationDate;
    private Double amountHours;
    private String dsWork;
    private Employee employee;
    private Project project;

    public WorkScheduleDTO(WorkSchedule workSchedule) {
        Employee employee = new Employee();
        Project project = new Project();

        employee.setId(workSchedule.getEmployee().getId());
        employee.setName(workSchedule.getEmployee().getName());

        project.setId(workSchedule.getProject().getId());
        project.setName(workSchedule.getProject().getName());
        project.setIsDone(workSchedule.getProject().getIsDone());

        this.id = workSchedule.getId();
        this.creationDate = workSchedule.getCreationDate();
        this.amountHours = workSchedule.getAmountHours();
        this.dsWork = workSchedule.getDsWork();
        this.employee =  employee;
        this.project = project;
    }

}
