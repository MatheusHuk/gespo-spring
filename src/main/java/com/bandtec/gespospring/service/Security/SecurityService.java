package com.bandtec.gespospring.service.Security;

import com.bandtec.gespospring.model.EmployeeModel;

public interface SecurityService {
    EmployeeModel autoLogin(String cpf, String password);
}
