package com.bandtec.gespospring.entity.view;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VW_PROVISIONING_HOURS")
public class VwProvisioningHours implements Serializable {

    @Id
    private Integer id;
    private Integer amountHours;
    private Date creationDate;

    @Column(name = "FK_CATEGORY")
    private Integer categoryId;

    @Column(name = "FK_PROJECT")
    private Integer projectId;

    @Column(name = "FK_EMPLOYEE")
    private Integer employeeId;

    public VwProvisioningHours(Integer projectId, Integer employeeId, Integer categoryId, String month) {
        this.projectId = projectId;
        this.employeeId = employeeId;
        this.categoryId = categoryId;

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
