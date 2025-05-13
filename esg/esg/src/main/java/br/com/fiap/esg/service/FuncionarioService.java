
package br.com.fiap.esg.service;

import br.com.fiap.esg.model.Funcionario;
import br.com.fiap.esg.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvarFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarFuncionario(Long id){
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if(funcionarioOptional.isPresent()){
            return funcionarioOptional.get();
        }else {
            throw new RuntimeException("Funcionário com ID " + id + " não encontrado.");
        }
    }

    public List<Funcionario> buscarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public void excluirFuncionario(Long id){
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if(funcionarioOptional.isPresent()){
            funcionarioRepository.delete(funcionarioOptional.get());
        } else {
            throw new RuntimeException("Funcionário com ID " + id + " não encontrado para exclusão.");
        }
    }

    public Funcionario atualizarFuncionario(Funcionario funcionario){
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funcionario.getIdFuncionario());
        if(funcionarioOptional.isPresent()){
            return funcionarioRepository.save(funcionario);
        } else {
            throw new RuntimeException("Funcionário com ID " + funcionario.getIdFuncionario() + " não encontrado para atualização.");
        }
    }
}