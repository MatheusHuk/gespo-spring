package com.bandtec.gespospring.DTO.request;

import com.bandtec.gespospring.entity.table.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkScheduleUpdateDTO {

    @NotNull
    private Integer id;
    @NotNull
    private Double amountHours;
    @NotNull
    private String dsWork;
    @NotNull
    private Project project;
    @NotNull
    private Date creationDate;

}
