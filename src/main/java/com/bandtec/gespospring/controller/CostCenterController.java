package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.table.CostCenter;
import com.bandtec.gespospring.service.CostCenter.CostCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cost-centers")
public class CostCenterController {

    @Autowired
    private CostCenterService costCenterService;

    @PostMapping
    public ResponseEntity create(
        @RequestBody List<CostCenter> costCenter
    ) {
        costCenterService.save(costCenter);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity read(
            @RequestParam Integer id
    ) {
        CostCenter costCenter = costCenterService.findById(id);

        return costCenter != null ?  ResponseEntity.status(HttpStatus.OK).body(costCenter) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public ResponseEntity update(
            @RequestBody CostCenter costCenter
    ) {
        return costCenterService.update(costCenter) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam Integer id
    ) {
        return costCenterService.delete(id) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
