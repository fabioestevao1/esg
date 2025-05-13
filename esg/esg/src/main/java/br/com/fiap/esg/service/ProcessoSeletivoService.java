
package br.com.fiap.esg.service;

import br.com.fiap.esg.model.ProcessoSeletivo;
import br.com.fiap.esg.repository.ProcessoSeletivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoSeletivoService {

    @Autowired
    private ProcessoSeletivoRepository processoSeletivoRepository;

    public ProcessoSeletivo salvarProcessoSeletivo(ProcessoSeletivo processoSeletivo){
        return processoSeletivoRepository.save(processoSeletivo);
    }

    public ProcessoSeletivo buscarProcessoSeletivo(Long id){
        Optional<ProcessoSeletivo> processoOptional = processoSeletivoRepository.findById(id);
        if(processoOptional.isPresent()){
            return processoOptional.get();
        }else {
            throw new RuntimeException("Processo Seletivo com ID " + id + " não encontrado.");
        }
    }

    public List<ProcessoSeletivo> buscarProcessosSeletivos(){
        return processoSeletivoRepository.findAll();
    }

    public void excluirProcessoSeletivo(Long id){
        Optional<ProcessoSeletivo> processoOptional = processoSeletivoRepository.findById(id);
        if(processoOptional.isPresent()){
            processoSeletivoRepository.delete(processoOptional.get());
        } else {
            throw new RuntimeException("Processo Seletivo com ID " + id + " não encontrado para exclusão.");
        }
    }

    public ProcessoSeletivo atualizarProcessoSeletivo(ProcessoSeletivo processoSeletivo){
        Optional<ProcessoSeletivo> processoOptional = processoSeletivoRepository.findById(processoSeletivo.getIdProcesso()); // Usando getIdProcesso()
        if(processoOptional.isPresent()){
            return processoSeletivoRepository.save(processoSeletivo);
        } else {
            throw new RuntimeException("Processo Seletivo com ID " + processoSeletivo.getIdProcesso() + " não encontrado para atualização.");
        }
    }
}