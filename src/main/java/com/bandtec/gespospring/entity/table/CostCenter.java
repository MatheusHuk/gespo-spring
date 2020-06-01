package com.bandtec.gespospring.entity.table;

import com.bandtec.gespospring.entity.AbstractModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COST_CENTER")
public class CostCenter extends AbstractModel {

    private String cnpj;
    private String name;

}
