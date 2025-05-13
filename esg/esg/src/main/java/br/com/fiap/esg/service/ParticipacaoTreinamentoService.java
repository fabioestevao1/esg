
package br.com.fiap.esg.service;

import br.com.fiap.esg.model.ParticipacaoTreinamento;
import br.com.fiap.esg.repository.ParticipacaoTreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipacaoTreinamentoService {

    @Autowired
    private ParticipacaoTreinamentoRepository participacaoTreinamentoRepository;

    public ParticipacaoTreinamento salvarParticipacaoTreinamento(ParticipacaoTreinamento participacaoTreinamento){
        return participacaoTreinamentoRepository.save(participacaoTreinamento);
    }

    public ParticipacaoTreinamento buscarParticipacaoTreinamento(Long id){
        Optional<ParticipacaoTreinamento> participacaoOptional = participacaoTreinamentoRepository.findById(id);
        if(participacaoOptional.isPresent()){
            return participacaoOptional.get();
        }else {
            throw new RuntimeException("Participação de Treinamento com ID " + id + " não encontrada.");
        }
    }

    public List<ParticipacaoTreinamento> buscarParticipacoesTreinamento(){
        return participacaoTreinamentoRepository.findAll();
    }

    public void excluirParticipacaoTreinamento(Long id){
        Optional<ParticipacaoTreinamento> participacaoOptional = participacaoTreinamentoRepository.findById(id);
        if(participacaoOptional.isPresent()){
            participacaoTreinamentoRepository.delete(participacaoOptional.get());
        } else {
            throw new RuntimeException("Participação de Treinamento com ID " + id + " não encontrada para exclusão.");
        }
    }

    public ParticipacaoTreinamento atualizarParticipacaoTreinamento(ParticipacaoTreinamento participacaoTreinamento){
        Optional<ParticipacaoTreinamento> participacaoOptional = participacaoTreinamentoRepository.findById(participacaoTreinamento.getIdParticipacao());
        if(participacaoOptional.isPresent()){
            return participacaoTreinamentoRepository.save(participacaoTreinamento);
        } else {
            throw new RuntimeException("Participação de Treinamento com ID " + participacaoTreinamento.getIdParticipacao() + " não encontrada para atualização.");
        }
    }
}