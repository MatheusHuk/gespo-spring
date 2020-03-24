package com.bandtec.gespospring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class WorkSchedule extends AbstractModel {

    private Double amountHours;

    private String dsWork;

    @Temporal(TemporalType.DATE)
    private Date scheduleDate;

    public WorkSchedule() {}

    public WorkSchedule(Double amountHours, String dsWork, Date scheduleDate) {
        this.amountHours = amountHours;
        this.dsWork = dsWork;
        this.scheduleDate = scheduleDate;
    }

    public Double getAmountHours() {
        return amountHours;
    }

    public void setAmountHours(Double amountHours) {
        this.amountHours = amountHours;
    }

    public String getDsWork() {
        return dsWork;
    }

    public void setDsWork(String dsWork) {
        this.dsWork = dsWork;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
