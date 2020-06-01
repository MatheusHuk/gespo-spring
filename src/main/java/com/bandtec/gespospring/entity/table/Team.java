package com.bandtec.gespospring.entity.table;

import com.bandtec.gespospring.entity.AbstractModel;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team extends AbstractModel { private String name; }
