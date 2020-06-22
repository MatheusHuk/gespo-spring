package com.bandtec.gespospring.entity.table;


import com.bandtec.gespospring.entity.AbstractModel;
import com.bandtec.gespospring.entity.view.VwProjectIsNot;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    List<Project> projects;

    public Employee(VwProjectIsNot vwProjectIsNot) {
        this.setId(vwProjectIsNot.getId());
        this.name = vwProjectIsNot.getName();
        this.email = vwProjectIsNot.getEmail();
        this.hourValue = vwProjectIsNot.getHourValue();
        this.category = new Category();
        this.category.setId(vwProjectIsNot.getFkCategory());
        this.team = new Team();
        this.team.setId(vwProjectIsNot.getFkTeam());
        this.permission = new Permission();
        this.permission.setId(vwProjectIsNot.getFkPermission());
        this.office = vwProjectIsNot.getOffice();
    }
}
