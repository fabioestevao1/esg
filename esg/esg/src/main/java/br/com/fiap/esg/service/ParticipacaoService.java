package br.com.fiap.esg.service;

import br.com.fiap.esg.dto.ParticipacaoDTO;
import br.com.fiap.esg.exception.EntityNotFoundException;
import br.com.fiap.esg.model.Funcionario;
import br.com.fiap.esg.model.Participacao;
import br.com.fiap.esg.model.Treinamento;
import br.com.fiap.esg.repository.FuncionarioRepository;
import br.com.fiap.esg.repository.ParticipacaoRepository;
import br.com.fiap.esg.repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipacaoService {

    @Autowired
    private ParticipacaoRepository participacaoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    public List<ParticipacaoDTO> listarTodos() {
        return participacaoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ParticipacaoDTO buscarPorId(Long id) {
        return participacaoRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Participação não encontrada com ID: " + id));
    }

    public List<ParticipacaoDTO> buscarPorFuncionario(Long funcionarioId) {
        if (!funcionarioRepository.existsById(funcionarioId)) {
            throw new EntityNotFoundException("Funcionário não encontrado com ID: " + funcionarioId);
        }
        return participacaoRepository.findByFuncionarioId(funcionarioId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ParticipacaoDTO> buscarPorTreinamento(Long treinamentoId) {
        if (!treinamentoRepository.existsById(treinamentoId)) {
            throw new EntityNotFoundException("Treinamento não encontrado com ID: " + treinamentoId);
        }
        return participacaoRepository.findByTreinamentoId(treinamentoId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ParticipacaoDTO criar(ParticipacaoDTO participacaoDTO) {
        Participacao participacao = convertToEntity(participacaoDTO);
        Participacao participacaoSalva = participacaoRepository.save(participacao);
        return convertToDTO(participacaoSalva);
    }

    public ParticipacaoDTO atualizar(Long id, ParticipacaoDTO participacaoDTO) {
        return participacaoRepository.findById(id)
                .map(participacaoExistente -> {
                    // Atualiza apenas os campos permitidos
                    participacaoExistente.setDataParticipacao(participacaoDTO.dataParticipacao());
                    participacaoExistente.setStatus(participacaoDTO.status());

                    // Atualiza funcionário se fornecido
                    if (participacaoDTO.funcionarioId() != null) {
                        Funcionario funcionario = funcionarioRepository.findById(participacaoDTO.funcionarioId())
                                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
                        participacaoExistente.setFuncionario(funcionario);
                    }

                    // Atualiza treinamento se fornecido
                    if (participacaoDTO.treinamentoId() != null) {
                        Treinamento treinamento = treinamentoRepository.findById(participacaoDTO.treinamentoId())
                                .orElseThrow(() -> new EntityNotFoundException("Treinamento não encontrado"));
                        participacaoExistente.setTreinamento(treinamento);
                    }

                    Participacao participacaoSalva = participacaoRepository.save(participacaoExistente);
                    return convertToDTO(participacaoSalva);
                })
                .orElseThrow(() -> new EntityNotFoundException("Participação não encontrada com ID: " + id));
    }
    public void deletar(Long id) {
        if (!participacaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Participação não encontrada com ID: " + id);
        }
        participacaoRepository.deleteById(id);
    }

    private ParticipacaoDTO convertToDTO(Participacao participacao) {
        return new ParticipacaoDTO(
                participacao.getId(),
                participacao.getDataParticipacao(),
                participacao.getStatus(),
                participacao.getFuncionario().getId(),
                participacao.getTreinamento().getId(),
                participacao.getFuncionario().getNome(),
                participacao.getTreinamento().getNome()
        );
    }

    private Participacao convertToEntity(ParticipacaoDTO dto) {
        Participacao participacao = new Participacao();
        participacao.setDataParticipacao(dto.dataParticipacao());
        participacao.setStatus(dto.status());

        participacao.setFuncionario(funcionarioRepository.findById(dto.funcionarioId())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com ID: " + dto.funcionarioId())));

        participacao.setTreinamento(treinamentoRepository.findById(dto.treinamentoId())
                .orElseThrow(() -> new EntityNotFoundException("Treinamento não encontrado com ID: " + dto.treinamentoId())));

        return participacao;
    }
}