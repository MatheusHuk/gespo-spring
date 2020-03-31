package com.bandtec.gespospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProvisioningHours extends AbstractModel {

    private Integer amountHours;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Employee employee;

}
