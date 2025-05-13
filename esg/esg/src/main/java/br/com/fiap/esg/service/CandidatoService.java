// src/main/java/br/com/fiap/esg/service/CandidatoService.java
package br.com.fiap.esg.service;

import br.com.fiap.esg.model.Candidato;
import br.com.fiap.esg.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository; // Instância injetada

    public Candidato salvarCandidato(Candidato candidato){
        // Correção: Usar a instância 'candidatoRepository'
        return candidatoRepository.save(candidato);
    }

    public Candidato buscarCandidato(Long id){
        Optional<Candidato> candidatoOptional = candidatoRepository.findById(id);

        if(candidatoOptional.isPresent()){
            return candidatoOptional.get();
        }else {
            // Correção: Mensagem mais específica
            throw new RuntimeException("Candidato com ID " + id + " não encontrado.");
        }
    }

    public List<Candidato> buscarCandidatos(){
        return candidatoRepository.findAll();
    }

    public void excluirCandidato(Long id){
        Optional<Candidato> candidatoOptional = candidatoRepository.findById(id);

        if(candidatoOptional.isPresent()){
            candidatoRepository.delete(candidatoOptional.get());
        } else {
            // Correção: Mensagem mais específica
            throw new RuntimeException("Candidato com ID " + id + " não encontrado para exclusão.");
        }
    }

    public Candidato atualizarCandidato(Candidato candidato){
        // Correção: Usar a instância 'candidatoRepository' e adicionar ';'
        Optional<Candidato> candidatoOptional = candidatoRepository.findById(candidato.getIdCandidato()); // Adicionado ';' e usando getter correto

        if(candidatoOptional.isPresent()){
            // Correção: Usar a instância 'candidatoRepository'
            return candidatoRepository.save(candidato);
        } else {
            // Correção: Mensagem mais específica
            throw new RuntimeException("Candidato com ID " + candidato.getIdCandidato() + " não encontrado para atualização.");
        }
    }
}