package com.bandtec.gespospring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Analista extends Funcionario {

    @Column(name = "cargo")
    private String cargo;

    public Analista() {
    }

    public Analista(String nome, Double valorHora, Integer identificacao, Integer horasTrabalhadas, String area, String cargo, String senha, String email) {
        super(nome, valorHora, identificacao, horasTrabalhadas, area, senha, email);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Analista{" +
                "cargo='" + cargo + '\'' +
                "} " + super.toString();
    }
}
