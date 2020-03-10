package com.bandtec.gespospring.model;

import java.util.Date;
import java.util.List;

public class Projeto {

    private Date dataEntrega;
    private Double custoProjeto;
    private List<Funcionario> funcionariosAlocados;

    public Projeto(Date dataEntrega, Double custoProjeto, List<Funcionario> funcionariosAlocados) {
        this.dataEntrega = dataEntrega;
        this.custoProjeto = custoProjeto;
        this.funcionariosAlocados = funcionariosAlocados;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public Double getCustoProjeto() {
        return custoProjeto;
    }

    public List<Funcionario> getFuncionariosAlocados() {
        return funcionariosAlocados;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setCustoProjeto(Double custoProjeto) {
        this.custoProjeto = custoProjeto;
    }

    public void setFuncionariosAlocados(List<Funcionario> funcionariosAlocados) {
        this.funcionariosAlocados = funcionariosAlocados;
    }

}
