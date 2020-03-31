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
public class Tasks extends AbstractModel {

    private String title;
    private String description;
    private Integer deadline;
    private Double percentProject;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Category category;
}
