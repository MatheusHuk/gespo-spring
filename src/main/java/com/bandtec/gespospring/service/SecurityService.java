package com.bandtec.gespospring.service;

import com.bandtec.gespospring.model.Employee;

public interface SecurityService {
    Employee autoLogin(String cpf, String password);
}
