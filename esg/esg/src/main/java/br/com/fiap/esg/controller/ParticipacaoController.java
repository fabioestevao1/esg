package br.com.fiap.esg.controller;

import br.com.fiap.esg.dto.ParticipacaoDTO;
import br.com.fiap.esg.service.ParticipacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/participacoes")
public class ParticipacaoController {

    @Autowired
    private ParticipacaoService participacaoService;

    @GetMapping
    public ResponseEntity<List<ParticipacaoDTO>> listarTodos() {
        List<ParticipacaoDTO> participacoes = participacaoService.listarTodos();
        return ResponseEntity.ok(participacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipacaoDTO> buscarPorId(@PathVariable Long id) {
        ParticipacaoDTO participacao = participacaoService.buscarPorId(id);
        return ResponseEntity.ok(participacao);
    }

    @GetMapping("/funcionario/{funcionarioId}")
    public ResponseEntity<List<ParticipacaoDTO>> buscarPorFuncionario(@PathVariable Long funcionarioId) {
        List<ParticipacaoDTO> participacoes = participacaoService.buscarPorFuncionario(funcionarioId);
        return ResponseEntity.ok(participacoes);
    }

    @GetMapping("/treinamento/{treinamentoId}")
    public ResponseEntity<List<ParticipacaoDTO>> buscarPorTreinamento(@PathVariable Long treinamentoId) {
        List<ParticipacaoDTO> participacoes = participacaoService.buscarPorTreinamento(treinamentoId);
        return ResponseEntity.ok(participacoes);
    }

    @PostMapping
    public ResponseEntity<ParticipacaoDTO> criar(@RequestBody ParticipacaoDTO participacaoDTO) {
        ParticipacaoDTO participacaoSalva = participacaoService.criar(participacaoDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(participacaoSalva.id())
                .toUri();
        return ResponseEntity.created(location).body(participacaoSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipacaoDTO> atualizar(
            @PathVariable Long id,
            @RequestBody ParticipacaoDTO participacaoDTO) {
        ParticipacaoDTO participacaoAtualizada = participacaoService.atualizar(id, participacaoDTO);
        return ResponseEntity.ok(participacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        participacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}