package com.bandtec.gespospring.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Tasks {

    private String title;

    private String description;

    private Integer deadline;

    @Column(name = "percent_project")
    private Double percentProject;

    public Tasks() {}

    public Tasks(String title, String description, Integer deadline, Double percentProject) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.percentProject = percentProject;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getDeadline() {
        return deadline;
    }
    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }
    public Double getPercentProject() {
        return percentProject;
    }
    public void setPercentProject(Double percentProject) {
        this.percentProject = percentProject;
    }
}
