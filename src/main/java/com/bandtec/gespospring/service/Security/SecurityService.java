package com.bandtec.gespospring.service.Security;

import com.bandtec.gespospring.DTO.EmployeeDTO;

public interface SecurityService {
    EmployeeDTO autoLogin(String cpf, String password);
}
