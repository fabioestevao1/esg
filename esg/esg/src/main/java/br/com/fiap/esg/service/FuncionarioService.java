package br.com.fiap.esg.service;

import br.com.fiap.esg.dto.FuncionarioDTO;
import br.com.fiap.esg.exception.EntityNotFoundException;
import br.com.fiap.esg.model.Funcionario;
import br.com.fiap.esg.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> listarTodos() {
        return funcionarioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FuncionarioDTO buscarPorId(Long id) {
        return funcionarioRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com ID: " + id));
    }

    public FuncionarioDTO salvar(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = convertToEntity(funcionarioDTO);
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return convertToDTO(funcionarioSalvo);
    }

    public FuncionarioDTO atualizar(Long id, FuncionarioDTO funcionarioDTO) {
        return funcionarioRepository.findById(id)
                .map(existente -> {
                    Funcionario funcionario = convertToEntity(funcionarioDTO);
                    funcionario.setId(id);
                    Funcionario atualizado = funcionarioRepository.save(funcionario);
                    return convertToDTO(atualizado);
                })
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com ID: " + id));
    }

    public void deletar(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Funcionário não encontrado com ID: " + id);
        }
        funcionarioRepository.deleteById(id);
    }

    private FuncionarioDTO convertToDTO(Funcionario funcionario) {
        return new FuncionarioDTO(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getTelefone(),
                funcionario.getIdade(),
                funcionario.getGenero(),
                funcionario.getEtnia(),
                funcionario.getSetor(),
                funcionario.getCargo(),
                funcionario.getDataAdmissao()
        );
    }

    private Funcionario convertToEntity(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.nome());
        funcionario.setEmail(dto.email());
        funcionario.setTelefone(dto.telefone());
        funcionario.setIdade(dto.idade());
        funcionario.setGenero(dto.genero());
        funcionario.setEtnia(dto.etnia());
        funcionario.setSetor(dto.setor());
        funcionario.setCargo(dto.cargo());
        funcionario.setDataAdmissao(dto.dataAdmissao());
        return funcionario;
    }
}