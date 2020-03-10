package com.bandtec.gespospring.model;

import java.time.LocalDateTime;

public class Usuario {

    private String email;
    private String senha;
    private LocalDateTime autenticacao;

    public Usuario(String email, String senha, LocalDateTime autenticao) {
        this.email = email;
        this.senha = senha;
        this.autenticacao = autenticao;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getAutenticacao() {
        return autenticacao;
    }
}
