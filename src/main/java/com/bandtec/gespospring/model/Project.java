package com.bandtec.gespospring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Project extends AbstractModel {

    private String name;

    private String dsProject;

    private String manager;

    private Integer isDone;

    @ManyToOne
    private CustCenter custCenter;

    public Project() {}

    public Project(String name, String dsProject, String manager, Integer isDone) {
        this.name = name;
        this.dsProject = dsProject;
        this.manager = manager;
        this.isDone = isDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsProject() {
        return dsProject;
    }

    public void setDsProject(String dsProject) {
        this.dsProject = dsProject;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getIsDone() {
        return isDone;
    }

    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }
}
