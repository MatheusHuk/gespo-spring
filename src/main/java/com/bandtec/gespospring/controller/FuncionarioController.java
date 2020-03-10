package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.model.Funcionario;
import com.bandtec.gespospring.model.Gestor;
import com.bandtec.gespospring.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

//    @PostMapping("/cadastro/analista")
//    public void create(
//            @RequestParam String nome,
//            @RequestParam Double valorHora,
//            @RequestParam Integer identificacao,
//            @RequestParam Integer horasTrabalhadas,
//            @RequestParam String area,
//            @RequestParam String cargo,
//            @RequestParam String senha,
//            @RequestParam String email
//    ){
//        Funcionario analista = new Analista(nome, valorHora, identificacao, horasTrabalhadas, area, cargo, senha, email);
//    }

    @PostMapping("/cadastro/gestor")
    public Funcionario create(
            @RequestBody Map<String, String> body
    ){
        System.out.println(body);
        String nome = body.get("nome");
        Double valorHora = Double.valueOf(body.get("valorHora"));
        Integer identificacao = Integer.valueOf(body.get("identificacao"));
        Integer horasTrabalhadas = Integer.valueOf(body.get("horasTrabalhadas"));
        String area = body.get("area");
        String senha = body.get("senha");
        String email = body.get("email");

        return funcionarioRepository.save(new Gestor(nome, valorHora, identificacao, horasTrabalhadas, area, senha, email));
    }

//    @PostMapping()
//    public void login(
//            @RequestParam String email,
//            @RequestParam String senha
//    ){
//
//    }
}

