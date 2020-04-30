package com.bandtec.gespospring.service;

import com.bandtec.gespospring.model.EmployeeModel;

public interface SecurityService {
    EmployeeModel autoLogin(String cpf, String password);
}
