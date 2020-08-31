package com.bandtec.gespospring.entity.table;

import com.bandtec.gespospring.DTO.request.ProjectDTO;
import com.bandtec.gespospring.entity.AbstractModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project extends AbstractModel {

    private String name;
    private String dsProject;
    private Integer isDone = 0;

    @ManyToOne
    @JoinColumn(name = "FK_CUST_CENTER")
    private CostCenter costCenter;

    @JsonIgnore
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    @ManyToOne
    @JoinColumn(name = "FK_MANAGER")
    private Employee manager;

    public Project(ProjectDTO projectDTO) {
        this.name = projectDTO.getName();
        this.dsProject = projectDTO.getDsProject();
        this.costCenter = projectDTO.getCostCenter();
        this.employees = projectDTO.getEmployees();
    }
}
