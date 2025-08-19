package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
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
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Ninjas mostrados";
    }

    // Mostrar Ninja por ID
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId(){
        return "Ninjas mostrados por ID";
    }

    // Alterar dados dos Ninjas
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Ninja alterado por ID";
    }

    // Deletar Ninjas
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }
}
