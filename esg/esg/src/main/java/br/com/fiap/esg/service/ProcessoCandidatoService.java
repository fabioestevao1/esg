// src/main/java/br/com/fiap/esg/service/ProcessoCandidatoService.java
package br.com.fiap.esg.service;

import br.com.fiap.esg.model.ProcessoCandidato;
import br.com.fiap.esg.repository.ProcessoCandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoCandidatoService {

    @Autowired
    private ProcessoCandidatoRepository processoCandidatoRepository;

    public ProcessoCandidato salvarProcessoCandidato(ProcessoCandidato processoCandidato){
        return processoCandidatoRepository.save(processoCandidato);
    }

    public ProcessoCandidato buscarProcessoCandidato(Long id){
        Optional<ProcessoCandidato> processoOptional = processoCandidatoRepository.findById(id);
        if(processoOptional.isPresent()){
            return processoOptional.get();
        }else {
            throw new RuntimeException("Processo do Candidato com ID " + id + " não encontrado.");
        }
    }

    public List<ProcessoCandidato> buscarProcessosCandidato(){
        return processoCandidatoRepository.findAll();
    }

    public void excluirProcessoCandidato(Long id){
        Optional<ProcessoCandidato> processoOptional = processoCandidatoRepository.findById(id);
        if(processoOptional.isPresent()){
            processoCandidatoRepository.delete(processoOptional.get());
        } else {
            throw new RuntimeException("Processo do Candidato com ID " + id + " não encontrado para exclusão.");
        }
    }

    public ProcessoCandidato atualizarProcessoCandidato(ProcessoCandidato processoCandidato){
        Optional<ProcessoCandidato> processoOptional = processoCandidatoRepository.findById(processoCandidato.getIdProcessoCandidato());
        if(processoOptional.isPresent()){
            return processoCandidatoRepository.save(processoCandidato);
        } else {
            throw new RuntimeException("Processo do Candidato com ID " + processoCandidato.getIdProcessoCandidato() + " não encontrado para atualização.");
        }
    }
}