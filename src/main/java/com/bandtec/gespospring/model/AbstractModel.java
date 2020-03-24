package com.bandtec.gespospring.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

// Abstract class that has generic tables attributes
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastUpdateDate;


    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

}
