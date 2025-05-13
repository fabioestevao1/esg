
package br.com.fiap.esg.service;

import br.com.fiap.esg.model.Treinamento;
import br.com.fiap.esg.repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinamentoService {

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    public Treinamento salvarTreinamento(Treinamento treinamento){
        return treinamentoRepository.save(treinamento);
    }

    public Treinamento buscarTreinamento(Long id){
        Optional<Treinamento> treinamentoOptional = treinamentoRepository.findById(id);
        if(treinamentoOptional.isPresent()){
            return treinamentoOptional.get();
        }else {
            throw new RuntimeException("Treinamento com ID " + id + " não encontrado.");
        }
    }

    public List<Treinamento> buscarTreinamentos(){
        return treinamentoRepository.findAll();
    }

    public void excluirTreinamento(Long id){
        Optional<Treinamento> treinamentoOptional = treinamentoRepository.findById(id);
        if(treinamentoOptional.isPresent()){
            treinamentoRepository.delete(treinamentoOptional.get());
        } else {
            throw new RuntimeException("Treinamento com ID " + id + " não encontrado para exclusão.");
        }
    }

    public Treinamento atualizarTreinamento(Treinamento treinamento){
        Optional<Treinamento> treinamentoOptional = treinamentoRepository.findById(treinamento.getIdTreinamento());
        if(treinamentoOptional.isPresent()){
            return treinamentoRepository.save(treinamento);
        } else {
            throw new RuntimeException("Treinamento com ID " + treinamento.getIdTreinamento() + " não encontrado para atualização.");
        }
    }
}