package com.bandtec.gespospring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project extends AbstractModel {

    private String name;
    private String dsProject;
    private String manager;
    private Integer isDone = 0;

    @ManyToOne
    @JoinColumn(name = "FK_CUST_CENTER")
    private CustCenter custCenter;

    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    private Set<Employee> employees;
}
