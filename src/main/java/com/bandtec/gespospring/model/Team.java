package com.bandtec.gespospring.model;

import javax.persistence.Entity;

@Entity
public class Team extends AbstractModel {

    private String name;

    public Team() {}

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
