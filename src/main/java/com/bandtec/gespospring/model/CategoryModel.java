package com.bandtec.gespospring.model;

import javax.persistence.Entity;

@Entity
public class CategoryModel extends AbstractModel {

    private String dsCategory;

    public CategoryModel() {
    }

    public CategoryModel(String dsCategory){
        this.dsCategory = dsCategory;
    }

    public String getDsCategory() {
        return dsCategory;
    }

    public void setDsCategory(String dsCategory) {
        this.dsCategory = dsCategory;
    }
}
