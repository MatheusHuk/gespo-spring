package com.bandtec.gespospring.entity.table;

import com.bandtec.gespospring.entity.AbstractModel;
import lombok.*;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROVISIONING_HOURS")
public class ProvisioningHours extends AbstractModel {

    private Double amountHours;

    @ManyToOne
    @JoinColumn(name = "FK_PROJECT")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "FK_EMPLOYEE")
    private Employee employee;

    public ProvisioningHours(Integer projectId, Integer employeeId, Integer categoryId, String month) {
        Employee employee = new Employee();
        Project project = new Project();
        Category category = new Category();

        category.setId(categoryId);
        employee.setCategory(category);
        employee.setId(employeeId);
        project.setId(projectId);

        this.employee = employee;
        this.project = project;

        try {
            if(month != null) {
                Date formattedDate = new SimpleDateFormat("yyyy-MM-dd").parse(month);
                this.setCreationDate(formattedDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
