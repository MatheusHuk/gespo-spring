package com.bandtec.gespospring.DTO.request;

import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Project;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ProvisioningHoursUpdateDTO {
    @NotNull
    private Integer id;

    @NotNull
    private Date creationDate;

    @NotNull
    private Double amountHours;

    @NotNull
    private Project project;

    @NotNull
    private Employee employee;
}
