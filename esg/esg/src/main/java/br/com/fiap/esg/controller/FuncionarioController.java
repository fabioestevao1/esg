
package br.com.fiap.esg.controller;

import br.com.fiap.esg.model.Funcionario;
import br.com.fiap.esg.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// import java.util.List; // Descomente se for usar o método de listar todos

@RestController
@RequestMapping("/api")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/funcionarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario adicionarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.salvarFuncionario(funcionario);
    }

    @GetMapping("/funcionarios/{funcionarioId}")
    public Funcionario buscarFuncionario(@PathVariable Long funcionarioId){
        return funcionarioService.buscarFuncionario(funcionarioId);
    }

    // @GetMapping("/funcionarios")
    // public List<Funcionario> listarFuncionarios(){
    //     return funcionarioService.buscarFuncionarios();
    // }

    @DeleteMapping("/funcionarios/{funcionarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirFuncionario(@PathVariable Long funcionarioId){
        funcionarioService.excluirFuncionario(funcionarioId);
    }

    @PutMapping("/funcionarios")
    @ResponseStatus(HttpStatus.OK)
    public Funcionario atualizarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.atualizarFuncionario(funcionario);
    }
}