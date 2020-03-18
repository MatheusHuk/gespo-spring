package com.bandtec.gespospring.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Project extends AbstractModel {

    private String name;

    @Column(name = "ds_project")
    private String dsProject;

    private String manager;

    @Column(name = "is_done")
    private Integer isDone;

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
