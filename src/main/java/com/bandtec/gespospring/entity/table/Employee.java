package com.bandtec.gespospring.entity.table;


import com.bandtec.gespospring.entity.AbstractModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Employee extends AbstractModel {

    private String cpf;
    private String name;
    private String password;
    private String email;
    private Double hourValue;
    private String office;

    @Temporal(TemporalType.DATE)
    private Date dtBirth;

    @ManyToOne
    @JoinColumn(name = "FK_TEAM")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "FK_PERMISSION")
    private Permission permission;

    @ManyToMany(mappedBy = "employees")
    @JsonIgnore
    Set<Project> projects;

}
