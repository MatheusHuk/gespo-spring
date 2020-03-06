package gespo.project.controller;

import gespo.project.model.Analista;
import gespo.project.model.Funcionario;
import gespo.project.model.Gestor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro/usuario")
public class UsuarioController {

    @PostMapping("/analista/")
    public void cadastrarAnalista(
            @RequestParam String nome,
            @RequestParam Double valorHora,
            @RequestParam Integer identificacao,
            @RequestParam Integer horasTrabalhadas,
            @RequestParam String area,
            @RequestParam String cargo,
            @RequestParam String senha,
            @RequestParam String email
    ){
        Funcionario analista = new Analista(nome, valorHora, identificacao, horasTrabalhadas, area, cargo, senha, email);
    }

    @PostMapping("/gestor/")
    public void cadastrarGestor(
            @RequestParam String nome,
            @RequestParam Double valorHora,
            @RequestParam Integer identificacao,
            @RequestParam Integer horasTrabalhadas,
            @RequestParam String area,
            @RequestParam List<Analista> analistasTime,
            @RequestParam String senha,
            @RequestParam String email
    ){
        Funcionario gestor = new Gestor(nome, valorHora, identificacao, horasTrabalhadas, area, analistasTime, senha, email);
    }

    @PostMapping()
    public void login(
            @RequestParam String email,
            @RequestParam String senha
    ){

    }
}
