package com.bandtec.gespospring.DTO;

import com.bandtec.gespospring.entity.table.Category;
import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.entity.view.VwProvisioningHours;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProvisioningHoursDTO {

    private Integer id;
    private Integer amountHours;
    private Date creationDate;

    private Employee employee;
    private Category category;
    private Project project;


    public ProvisioningHoursDTO(VwProvisioningHours vwProvisioningHours) {
        this.employee = new Employee();
        this.category = new Category();
        this.project = new Project();
        
        this.id = vwProvisioningHours.getId();
        this.amountHours = vwProvisioningHours.getAmountHours();
        this.creationDate = vwProvisioningHours.getCreationDate();

        this.employee.setId(vwProvisioningHours.getEmployeeId());
        this.employee.setName(vwProvisioningHours.getEmployeeName());

        this.category.setId(vwProvisioningHours.getCategoryId());
        this.category.setDsCategory(vwProvisioningHours.getDsCategory());

        this.project.setIsDone(null);
        this.project.setId(vwProvisioningHours.getProjectId());
        this.project.setName(vwProvisioningHours.getProjectName());
    }
}
