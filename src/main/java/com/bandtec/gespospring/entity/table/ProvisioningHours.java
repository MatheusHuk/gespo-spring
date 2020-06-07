package com.bandtec.gespospring.entity.table;

import com.bandtec.gespospring.entity.AbstractModel;
import lombok.*;

import javax.persistence.*;

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

}
