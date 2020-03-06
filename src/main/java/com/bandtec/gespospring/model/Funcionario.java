package com.bandtec.gespospring.model;

import javax.persistence.*;

@Entity
@Table(name = "funcionario")
public abstract class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor_hora")
    private Double valorHora;

    @Column(name = "identificacao")
    private Integer identificacao;

    @Column(name = "horas_trabalhadas")
    private Integer horasTrabalhadas;

    @Column(name = "area")
    private String area;

    @Column(name = "senha")
    private String senha;

    @Column(name = "email")
    private String email;

    public Funcionario() {}

    public Funcionario(String nome, Double valorHora, Integer identificacao, Integer horasTrabalhadas, String area, String senha, String email) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.identificacao = identificacao;
        this.horasTrabalhadas = horasTrabalhadas;
        this.area = area;
        this.senha = senha;
        this.email = email;
    }

    public Double calcularSalario(){
        return  horasTrabalhadas * valorHora;
    }

    public Integer horaExtra(){
        Integer horaExtra = horasTrabalhadas > 40 ? horasTrabalhadas - 40 : 0;

        return horaExtra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Integer getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Integer identificacao) {
        this.identificacao = identificacao;
    }

    public Integer getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", valorHora=" + valorHora +
                ", identificacao=" + identificacao +
                ", horasTrabalhadas=" + horasTrabalhadas +
                ", salario=" + calcularSalario() +
                ", horaExtra="+ horaExtra() +
                ", area='" + area + '\'' +
                '}';
    }
}
