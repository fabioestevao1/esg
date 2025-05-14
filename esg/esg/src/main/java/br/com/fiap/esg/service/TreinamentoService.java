package br.com.fiap.esg.service;

import br.com.fiap.esg.dto.TreinamentoDTO;
import br.com.fiap.esg.exception.EntityNotFoundException;
import br.com.fiap.esg.model.Treinamento;
import br.com.fiap.esg.repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreinamentoService {

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    public List<TreinamentoDTO> listarTodos() {
        return treinamentoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TreinamentoDTO buscarPorId(Long id) {
        return treinamentoRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Treinamento não encontrado com ID: " + id));
    }

    public TreinamentoDTO salvar(TreinamentoDTO treinamentoDTO) {
        Treinamento treinamento = convertToEntity(treinamentoDTO);
        Treinamento treinamentoSalvo = treinamentoRepository.save(treinamento);
        return convertToDTO(treinamentoSalvo);
    }

    public TreinamentoDTO atualizar(Long id, TreinamentoDTO treinamentoDTO) {
        return treinamentoRepository.findById(id)
                .map(existente -> {
                    Treinamento treinamento = convertToEntity(treinamentoDTO);
                    treinamento.setId(id);
                    Treinamento atualizado = treinamentoRepository.save(treinamento);
                    return convertToDTO(atualizado);
                })
                .orElseThrow(() -> new EntityNotFoundException("Treinamento não encontrado com ID: " + id));
    }

    public void deletar(Long id) {
        if (!treinamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Treinamento não encontrado com ID: " + id);
        }
        treinamentoRepository.deleteById(id);
    }

    private TreinamentoDTO convertToDTO(Treinamento treinamento) {
        return new TreinamentoDTO(
                treinamento.getId(),
                treinamento.getNome(),
                treinamento.getDescricao(),
                treinamento.getDataInicio(),
                treinamento.getDataFim(),
                treinamento.isObrigatorio()
        );
    }

    private Treinamento convertToEntity(TreinamentoDTO dto) {
        Treinamento treinamento = new Treinamento();
        treinamento.setNome(dto.nome());
        treinamento.setDescricao(dto.descricao());
        treinamento.setDataInicio(dto.dataInicio());
        treinamento.setDataFim(dto.dataFim());
        treinamento.setObrigatorio(dto.obrigatorio() ? 'S' : 'N');
        return treinamento;
    }
}