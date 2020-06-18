package com.bandtec.gespospring.DTO.update;

import com.bandtec.gespospring.entity.table.CostCenter;
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

    @NotBlank
    @NotNull
    private String manager;

    @NotBlank
    @NotNull
    private String dsProject;
}
