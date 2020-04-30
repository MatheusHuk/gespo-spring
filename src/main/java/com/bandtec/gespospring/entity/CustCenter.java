package com.bandtec.gespospring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "CUST_CENTER")
public class CustCenter extends AbstractModel {

    private String cnpj;
    private String name;

}
