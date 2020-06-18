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
    private String manager;
    private Integer isDone = 0;

    @ManyToOne
    @JoinColumn(name = "FK_CUST_CENTER")
    private CostCenter costCenter;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EMPLOYEES_PROJECTS",
            joinColumns = @JoinColumn(name = "FK_PROJECT"),
            inverseJoinColumns = @JoinColumn(name = "FK_EMPLOYEE"))
    private List<Employee> employees;

    public Project(ProjectDTO projectDTO) {
        this.name = projectDTO.getName();
        this.dsProject = projectDTO.getDsProject();
        this.manager = projectDTO.getManager();
        this.costCenter = projectDTO.getCostCenter();
        this.employees = projectDTO.getEmployees();
    }
}
