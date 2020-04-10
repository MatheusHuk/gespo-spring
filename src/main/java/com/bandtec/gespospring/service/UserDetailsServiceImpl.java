package com.bandtec.gespospring.service;

import com.bandtec.gespospring.model.Employee;
import com.bandtec.gespospring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String cpf) {
        Employee employee = employeeRepository.findByCpf(cpf);

        if (employee == null) throw new UsernameNotFoundException("Usuário não encontrado, cpf: "+cpf);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + employee.getPermission().getDsPermission()));
        User user = new User(employee.getCpf(), employee.getPassword(), grantedAuthorities);

        return user;
    }
}
