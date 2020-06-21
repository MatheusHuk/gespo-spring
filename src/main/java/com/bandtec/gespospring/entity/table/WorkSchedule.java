package com.bandtec.gespospring.entity.table;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WORK_SCHEDULE")
public class WorkSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastUpdateDate;

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

        if(date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate formattedDate = LocalDate.parse(date, formatter);
            this.setCreationDate(formattedDate);
        }
    }
}
