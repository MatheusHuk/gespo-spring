package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.table.CustCenter;
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
        @RequestBody List<CustCenter> costCenter
    ) {
        costCenterService.save(costCenter);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity read(
            @RequestParam Integer id
    ) {
        CustCenter custCenter = costCenterService.findById(id);

        return custCenter != null ?  ResponseEntity.status(HttpStatus.OK).body(custCenter) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public ResponseEntity update(
            @RequestBody CustCenter custCenter
    ) {
        return costCenterService.update(custCenter) ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam Integer id
    ) {
        return costCenterService.delete(id) ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
