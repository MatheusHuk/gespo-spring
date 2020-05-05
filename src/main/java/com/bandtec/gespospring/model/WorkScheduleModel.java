package com.bandtec.gespospring.model;

import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.entity.table.WorkSchedule;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkScheduleModel {

    public WorkScheduleModel(WorkSchedule workSchedule) {
        Employee emp = new Employee();
        Project pro = new Project();

        emp.setId(workSchedule.getEmployee().getId());
        emp.setName(workSchedule.getEmployee().getName());

        pro.setId(workSchedule.getProject().getId());
        pro.setName(workSchedule.getProject().getName());

        this.id = workSchedule.getId();
        this.creationDate = workSchedule.getCreationDate();
        this.amountHours = workSchedule.getAmountHours();
        this.dsWork = workSchedule.getDsWork();
        this.employee =  emp;
        this.project = pro;
    }

    private Integer id;
    private Date creationDate;
    private Double amountHours;
    private String dsWork;
    private Employee employee;
    private Project project;

}
