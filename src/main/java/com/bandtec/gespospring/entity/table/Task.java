package com.bandtec.gespospring.entity.table;

import com.bandtec.gespospring.entity.AbstractModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
