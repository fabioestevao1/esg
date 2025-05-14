package br.com.fiap.esg.controller;

import br.com.fiap.esg.dto.TreinamentoDTO;
import br.com.fiap.esg.service.TreinamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/treinamentos")
public class TreinamentoController {

    @Autowired
    private TreinamentoService treinamentoService;

    @GetMapping
    public ResponseEntity<List<TreinamentoDTO>> listarTodos() {
        List<TreinamentoDTO> treinamentos = treinamentoService.listarTodos();
        return ResponseEntity.ok(treinamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinamentoDTO> buscarPorId(@PathVariable Long id) {
        TreinamentoDTO treinamento = treinamentoService.buscarPorId(id);
        return ResponseEntity.ok(treinamento);
    }

    @PostMapping
    public ResponseEntity<TreinamentoDTO> criar(@RequestBody TreinamentoDTO treinamentoDTO) {
        TreinamentoDTO treinamentoSalvo = treinamentoService.salvar(treinamentoDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(treinamentoSalvo.id())
                .toUri();
        return ResponseEntity.created(location).body(treinamentoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinamentoDTO> atualizar(
            @PathVariable Long id,
            @RequestBody TreinamentoDTO treinamentoDTO) {
        TreinamentoDTO treinamentoAtualizado = treinamentoService.atualizar(id, treinamentoDTO);
        return ResponseEntity.ok(treinamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        treinamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}