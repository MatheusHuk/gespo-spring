package com.bandtec.gespospring.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee extends AbstractModel{

    private String cpf;

    private String name;

    private String password;

    private String email;

    private Double hourValue;

    @Temporal(TemporalType.DATE)
    private Date dtBirth;

    public Employee() {}

    public Employee(String cpf, String name, String password, String email, Double hourValue, Date dtBirth) {
        this.cpf = cpf;
        this.name = name;
        this.password = password;
        this.email = email;
        this.hourValue = hourValue;
        this.dtBirth = dtBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getHourValue() {
        return hourValue;
    }

    public void setHourValue(Double hourValue) {
        this.hourValue = hourValue;
    }

    public Date getDtBirth() {
        return dtBirth;
    }

    public void setDtBirth(Date dtBirth) {
        this.dtBirth = dtBirth;
    }
}
