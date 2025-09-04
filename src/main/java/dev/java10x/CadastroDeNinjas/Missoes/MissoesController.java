package dev.java10x.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
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
    @Operation(summary = "Lista todas as missões", description = "Rota lista todas as missões cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missões listadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhuma missão foi encontrada")
    })
    public ResponseEntity<List<MissoesDTO>> listarMissao(){
        List<MissoesDTO> missoes = missoesService.listarMissao();
        return ResponseEntity.ok(missoes);
    }

    // Mostrar Missão por Id
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista a missão pelo id", description = "Rota lista a missão pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão listada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<?> listarMissaoPorId(
            @Parameter(description = "Usuário informa o id no caminho da requisição")
            @PathVariable Long id){
        if(missoesService.listarMissaoPorId(id) != null){
            MissoesDTO missao = missoesService.listarMissaoPorId(id);
            return ResponseEntity.ok(missao);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão não encontrada");
        }
    }

    // Adicionar Missao
    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova missão", description = "Rota cria uma nova missão e a insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão")
    })
    public ResponseEntity<String> criarMissao(
            @Parameter(description = "Usuário informa os dados da missão a ser cadastrado no corpo da requisição")
            @RequestBody MissoesDTO missao){
        MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso");
    }

    // Alterar dados da Missão
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Atualiza a missão por id", description = "Rota atualiza a missão pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada, não foi possível alterar")
    })
    public ResponseEntity<?> alterarMissao(
            @Parameter(description = "Usuário informa o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário informa os dados da missão a ser alterada no corpo da requisição")
            @RequestBody MissoesDTO missaoDTO){
        if(missoesService.listarMissaoPorId(id) != null){
            MissoesDTO missaoAtualizada = missoesService.atualizaMissao(id, missaoDTO);
            return ResponseEntity.ok(missaoAtualizada);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão não encontrada");
        }
    }

    // Deletar Missão
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta a missão pelo id", description = "Rota deleta a missão pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada, não foi possível deletar")
    })
    public ResponseEntity<String> deletarMissaoPorId(
            @Parameter(description = "Usuário informar o id pelo caminho da requisição")
            @PathVariable Long id){
        if (missoesService.listarMissaoPorId(id) != null){
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão deletada com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão não encontrada");
        }
    }
}
