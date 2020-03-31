package com.bandtec.gespospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee extends AbstractModel{

    private String cpf;
    private String name;
    private String password;
    private String email;
    private Double hourValue;

    @Temporal(TemporalType.DATE)
    private Date dtBirth;

    @ManyToMany
    private Set<Project> projects;

    @ManyToOne
    private Office office;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Category category;


}
