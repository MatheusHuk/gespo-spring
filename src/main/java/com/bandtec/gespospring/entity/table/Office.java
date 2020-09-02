package com.bandtec.gespospring.entity.table;

import com.bandtec.gespospring.entity.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Office extends AbstractModel {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    private String name;

    private String dsOffice;

    @ManyToOne
    @JoinColumn(name = "FK_PERMISSION")
    private Permission permission;

    public Office(Integer id, Date creationDate, Date lastUpdateDate, String name, String dsOffice, Permission permission) {
        super(id, creationDate, lastUpdateDate);
        this.name = name;
        this.dsOffice = dsOffice;
        this.permission = permission;
    }
}
