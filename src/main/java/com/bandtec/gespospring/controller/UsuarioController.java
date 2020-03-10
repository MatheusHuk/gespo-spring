package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.model.Usuario;
import com.bandtec.gespospring.utils.AuthUser;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    private Usuario usuario;

    @GetMapping
    public Usuario getUser(){
        if(usuario == null) return null;
        return usuario;
    }

    @PostMapping("/login")
    public String login(
            @RequestBody Map<String, String> body
    ){
        String result = AuthUser.autenticate(body.get("email"), body.get("senha"));

        if(result.equals("Logado"))
            usuario = new Usuario(body.get("email"), body.get("senha"), LocalDateTime.now());

        return result;
    }

    @DeleteMapping("/logoff")
    public Boolean logoff(){
        usuario = null;
        return true;
    }
}
