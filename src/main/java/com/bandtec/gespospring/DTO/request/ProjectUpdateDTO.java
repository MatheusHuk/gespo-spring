package com.bandtec.gespospring.DTO.request;

import com.bandtec.gespospring.entity.table.CostCenter;
import com.bandtec.gespospring.entity.table.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProjectUpdateDTO {
    @NotNull
    private Integer id;

    @NotBlank
    @NotNull
    private String name;

    @NotNull
    private CostCenter costCenter;

    @NotNull
    private Employee manager;

    @NotBlank
    @NotNull
    private String dsProject;
}
