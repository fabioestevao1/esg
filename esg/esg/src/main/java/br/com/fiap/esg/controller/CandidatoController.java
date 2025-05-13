// src/main/java/br/com/fiap/esg/controller/CandidatoController.java
package br.com.fiap.esg.controller;

import br.com.fiap.esg.model.Candidato;
import br.com.fiap.esg.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Adicionado para o método buscarCandidatos, se for exposto

@RestController
@RequestMapping("/api")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping("/candidatos")
    @ResponseStatus(HttpStatus.CREATED)
    public Candidato adicionarCandidato(@RequestBody Candidato candidato){
        return candidatoService.salvarCandidato(candidato);
    }

    @GetMapping("/candidatos/{candidatoId}")
    public Candidato buscarCandidato(@PathVariable Long candidatoId){
        return candidatoService.buscarCandidato(candidatoId);
    }

    // Se quiser expor a lista de todos os candidatos:
    // @GetMapping("/candidatos")
    // public List<Candidato> listarCandidatos(){
    //     return candidatoService.buscarCandidatos();
    // }

    @DeleteMapping("/candidatos/{candidatoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // É comum usar NO_CONTENT para delete sem retorno
    public void excluirCandidato(@PathVariable Long candidatoId){
        candidatoService.excluirCandidato(candidatoId);
    }

    @PutMapping("/candidatos") // Geralmente se passa o ID no path também para PUT: /candidatos/{candidatoId}
    @ResponseStatus(HttpStatus.OK)
    public Candidato atualizarCandidato(@RequestBody Candidato candidato){
        // Seria bom ter uma verificação se o candidato.getIdCandidato() não é nulo
        // e se corresponde a um ID de path, caso o path do PutMapping fosse "/candidatos/{id}"
        return candidatoService.atualizarCandidato(candidato);
    }
}