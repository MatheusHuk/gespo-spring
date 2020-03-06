package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
