package com.bandtec.gespospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkSchedule extends AbstractModel {

    private Double amountHours;
    private String dsWork;

    @Temporal(TemporalType.DATE)
    private Date scheduleDate;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Employee employee;
}
