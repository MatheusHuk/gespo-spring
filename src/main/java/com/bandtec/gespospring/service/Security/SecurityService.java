package com.bandtec.gespospring.service.Security;

import com.bandtec.gespospring.DTO.response.EmployeeLoginDTO;

public interface SecurityService {
    EmployeeLoginDTO autoLogin(String cpf, String password);
}
