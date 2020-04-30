package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.CustCenter;
import com.bandtec.gespospring.service.CustCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cost-centers")
public class CustCenterController {

    @Autowired
    private CustCenterService custCenterService;

    @PostMapping
    public ResponseEntity create(
        @RequestBody List<CustCenter> custCenter
    ) {
        custCenterService.save(custCenter);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity read(
            @RequestParam Integer id
    ) {
        CustCenter custCenter = custCenterService.findById(id);

        return custCenter != null ?  ResponseEntity.status(HttpStatus.OK).body(custCenter) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public ResponseEntity update(
            @RequestBody CustCenter custCenter
    ) {
        return custCenterService.update(custCenter) ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam Integer id
    ) {
        return custCenterService.delete(id) ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
