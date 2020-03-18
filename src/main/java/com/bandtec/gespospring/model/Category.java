package com.bandtec.gespospring.model;

import javax.persistence.Entity;

@Entity
public class Category extends AbstractModel {

    private String dsCategory;

    public Category() {
    }

    public Category(String dsCategory){
        this.dsCategory = dsCategory;
    }

    public String getDsCategory() {
        return dsCategory;
    }

    public void setDsCategory(String dsCategory) {
        this.dsCategory = dsCategory;
    }
}
