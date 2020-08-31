package com.bandtec.gespospring.entity.view;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VW_PROJECT_IS_NOT")
public class VwProjectIsNot implements Serializable {

    @Id
    private Integer Id;
    private String name;
    private String password;
    private String email;
    private Double hourValue;
    private Date dtBirth;
    private Integer fkCategory;
    private String dsCategory;
    private Integer fkTeam;
    private String teamName;
    private Date creationDate;
    private Date lastUpdateDate;
    private Integer fkOffice;
    private String projectIds;
}
