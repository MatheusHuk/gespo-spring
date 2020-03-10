package com.bandtec.gespospring.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "funcionario")
public class Gestor extends Funcionario {

    public Gestor(){}

    public Gestor(String nome, Double valorHora, Integer identificacao, Integer horasTrabalhadas, String area, String senha, String email) {
        super(nome, valorHora, identificacao, horasTrabalhadas, area, senha, email);
    }

    @Override
    public String toString() {
        return "Gestor{" +
                "} " + super.toString();
    }
}
