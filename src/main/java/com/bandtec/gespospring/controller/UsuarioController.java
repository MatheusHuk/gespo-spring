package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.model.Usuario;
import com.bandtec.gespospring.utils.AuthUser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

public class UsuarioController {

    private Usuario usuario;

    @GetMapping
    public Usuario getUser(){
        if(usuario == null) return null;
        return usuario;
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String senha
    ){
        String result = AuthUser.autenticate(email, senha);

        if(result.equals("Logado"))
            usuario = new Usuario(email, senha, LocalDateTime.now());

        return result;
    }

    @DeleteMapping("/logoff")
    public Boolean logoff(){
        usuario = null;
        return true;
    }
}
