package com.bandtec.gespospring.entity.table;

import com.bandtec.gespospring.entity.AbstractModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WORK_SCHEDULE")
public class WorkSchedule extends AbstractModel {

    private Double amountHours;
    private String dsWork;

    @ManyToOne
    @JoinColumn(name = "FK_PROJECT")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "FK_EMPLOYEE")
    private Employee employee;

    public WorkSchedule(Integer projectId, Integer employeeId, String date) {
        this.project = new Project();
        this.employee = new Employee();

        this.project.setIsDone(null);
        this.project.setId(projectId);
        this.employee.setId(employeeId);

        try {
            if(date != null) {
                Date formattedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                this.setCreationDate(formattedDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
