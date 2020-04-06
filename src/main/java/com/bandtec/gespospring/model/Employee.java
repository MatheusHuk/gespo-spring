package com.bandtec.gespospring.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee extends AbstractModel{

    private String cpf;
    private String name;
    private String password;
    private String email;
    private Double hourValue;

    @Temporal(TemporalType.DATE)
    private Date dtBirth;

    @ManyToMany
    @JoinColumn(name = "FK_PROJECT")
    @JoinTable(name = "EMPLOYEES_PROJECTS",
    joinColumns = @JoinColumn(name = "FK_EMPLOYEE"),
    inverseJoinColumns = @JoinColumn(name = "FK_PROJECT"))
    private Set<Project> projects;

    @ManyToOne
    @JoinColumn(name = "FK_TEAM")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "FK_PERMISSION")
    private Permission permission;

}
