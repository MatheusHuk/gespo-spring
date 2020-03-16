package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.model.CustCenter;
import com.bandtec.gespospring.repository.CustCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust-center")
public class CustCenterController {

    @Autowired
    CustCenterRepository custCenterRepository;

    @PostMapping("/cadastro")
    public CustCenter create(
        @RequestBody CustCenter custCenter
    ) {return custCenterRepository.save(custCenter);}
}
