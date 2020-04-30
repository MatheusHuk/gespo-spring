package com.bandtec.gespospring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task extends AbstractModel {

    private String title;
    private String description;
    private Integer deadline;
    private Double percentProject;

    @ManyToOne
    @JoinColumn(name = "FK_PROJECT")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "FK_ASSIGNEE")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY")
    private Category category;
}
