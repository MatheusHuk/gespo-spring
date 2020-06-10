package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.table.ProvisioningHours;
import com.bandtec.gespospring.entity.view.VwProvisioningHours;
import com.bandtec.gespospring.DTO.VwProvisioningHoursDTO;
import com.bandtec.gespospring.service.ProvisioningHours.ProvisioningHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/provisioning-hours")
public class ProvisioningHoursController {

    @Autowired
    private ProvisioningHoursService provisioningHoursService;

    @PostMapping
    public ResponseEntity create(
            @RequestBody List<ProvisioningHours> provisioningHours
    ) {
        try {
            provisioningHoursService.save(provisioningHours);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity read(
            @RequestParam Integer id
    ) {
        ProvisioningHours provisioningHours = provisioningHoursService.findById(id);

        return provisioningHours != null ? ResponseEntity.status(HttpStatus.OK).body(provisioningHours) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public ResponseEntity update(
            @RequestBody ProvisioningHours provisioningHours
    ) {
        return provisioningHoursService.update(provisioningHours) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam Integer id
    ) {
        return provisioningHoursService.delete(id) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/filter")
    public ResponseEntity readByFilter(
            @RequestParam Integer projectId,
            @RequestParam(required = false) Integer employeeId,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String month
    ) {
        VwProvisioningHours provisioningHoursMouth = new VwProvisioningHours(projectId, employeeId,
                categoryId, month);

         List<VwProvisioningHoursDTO> provisioningHoursModels = provisioningHoursService.findByFilter(provisioningHoursMouth);

         return provisioningHoursModels.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                 ResponseEntity.status(HttpStatus.OK).body(provisioningHoursModels);
    }
}
