package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // Mostrar Missão
    @GetMapping("/listar")
    public String listarMissao(){
        return "Missões listadas";
    }

    // Adicionar Missao
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada";
    }

    // Alterar dados da Missão
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada";
    }

    // Deletar Missão
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada";
    }
}
