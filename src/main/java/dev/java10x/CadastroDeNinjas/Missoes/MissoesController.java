package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    // Mostrar Missão
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missoesService.listarMissao();
    }

    // Mostrar Missão por Id
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
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
