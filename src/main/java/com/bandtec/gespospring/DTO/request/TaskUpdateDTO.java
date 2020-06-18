package com.bandtec.gespospring.DTO.request;

import com.bandtec.gespospring.entity.table.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateDTO {

    @NotNull
    private Integer id;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    private Integer deadline;
    @NotNull
    private Double percentProject;
    @NotNull
    private Category category;

}
