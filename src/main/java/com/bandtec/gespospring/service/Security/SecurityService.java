package com.bandtec.gespospring.service.Security;

import com.bandtec.gespospring.entity.table.Employee;

public interface SecurityService {
    Employee autoLogin(String cpf, String password);
}
