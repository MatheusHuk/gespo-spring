package com.bandtec.gespospring.DTO.request;

import com.bandtec.gespospring.entity.table.CostCenter;
import com.bandtec.gespospring.entity.table.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ProjectDTO {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String dsProject;

    @NotBlank
    @NotNull
    private String manager;

    @NotNull
    private CostCenter costCenter;

    @NotNull
    private List<Employee> employees;

}
