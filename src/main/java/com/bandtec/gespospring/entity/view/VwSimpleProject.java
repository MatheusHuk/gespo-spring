package com.bandtec.gespospring.entity.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "VW_SIMPLE_PROJECT")
@NoArgsConstructor
@Getter
@Setter
public class VwSimpleProject implements Serializable {

    public VwSimpleProject(VwSimpleProject vwSimpleProject) {
        this.id = vwSimpleProject.getId();
        this.name = vwSimpleProject.getName();
        this.dsProject = vwSimpleProject.getDsProject();
        this.manager = vwSimpleProject.getManager();
        this.isDone = vwSimpleProject.getIsDone();
    }

    @Id
    private Integer id;
    @Id
    private Integer employeeId;
    private String name;
    private String dsProject;
    private String manager;
    private Integer isDone = 0;
}
