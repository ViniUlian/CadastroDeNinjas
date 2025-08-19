package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os Ninjas
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Ninjas mostrados";
    }

    // Mostrar Ninja por ID
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Ninjas mostrados por ID";
    }

    // Alterar dados dos Ninjas
    @PutMapping("/alterar")
    public String alterarNinjaPorId(){
        return "Ninja alterado por ID";
    }

    // Deletar Ninjas
    @DeleteMapping("/deletar")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }
}
