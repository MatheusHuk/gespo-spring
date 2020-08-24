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

    @Temporal(TemporalType.DATE)
    private Date dtBirth;

    @ManyToOne
    @JoinColumn(name = "FK_TEAM")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY")
    private Category category;

    @ManyToMany(mappedBy = "employees")
    @JsonIgnore
    List<Project> projects;

    @ManyToOne
    @JoinColumn(name = "FK_OFFICE")
    private Office office;

    public Employee(VwProjectIsNot vwProjectIsNot) {
        this.setId(vwProjectIsNot.getId());
        this.name = vwProjectIsNot.getName();
        this.email = vwProjectIsNot.getEmail();
        this.hourValue = vwProjectIsNot.getHourValue();
        this.category = new Category();
        this.category.setId(vwProjectIsNot.getFkCategory());
        this.category.setDsCategory(vwProjectIsNot.getDsCategory());
        this.team = new Team();
        this.team.setName(vwProjectIsNot.getTeamName());
        this.team.setId(vwProjectIsNot.getFkTeam());
        this.office.setId(vwProjectIsNot.getFkOffice());
    }
}
