package com.bandtec.gespospring.entity.table;

import com.bandtec.gespospring.entity.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
        Project project = new Project();
        Employee employee = new Employee();

        project.setId(projectId);
        employee.setId(employeeId);

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
