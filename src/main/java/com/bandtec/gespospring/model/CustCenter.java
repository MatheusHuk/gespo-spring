package com.bandtec.gespospring.model;

import javax.persistence.Entity;

@Entity
public class CustCenter extends AbstractModel {

    private String cnpj;

    private String name;

    public CustCenter() {}

    public CustCenter(String cnpj, String name) {
        this.cnpj = cnpj;
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
