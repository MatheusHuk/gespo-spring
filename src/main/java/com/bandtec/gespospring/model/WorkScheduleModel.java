package com.bandtec.gespospring.model;

import com.bandtec.gespospring.entity.table.WorkSchedule;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkScheduleModel {

    public WorkScheduleModel(WorkSchedule workSchedule) {
        this.id = workSchedule.getId();
        this.creationDate = workSchedule.getCreationDate();
        this.amountHours = workSchedule.getAmountHours();
        this.dsWork = workSchedule.getDsWork();
    }

    private Integer id;
    private Date creationDate;
    private Double amountHours;
    private String dsWork;

}
