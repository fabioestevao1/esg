
package br.com.fiap.esg.controller;

import br.com.fiap.esg.model.ParticipacaoTreinamento;
import br.com.fiap.esg.service.ParticipacaoTreinamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// import java.util.List; // Descomente se for usar o método de listar todos

@RestController
@RequestMapping("/api")
public class ParticipacaoTreinamentoController {

    @Autowired
    private ParticipacaoTreinamentoService participacaoTreinamentoService;

    @PostMapping("/participacoes-treinamento")
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipacaoTreinamento adicionarParticipacaoTreinamento(@RequestBody ParticipacaoTreinamento participacaoTreinamento){
        return participacaoTreinamentoService.salvarParticipacaoTreinamento(participacaoTreinamento);
    }

    @GetMapping("/participacoes-treinamento/{participacaoId}")
    public ParticipacaoTreinamento buscarParticipacaoTreinamento(@PathVariable Long participacaoId){
        return participacaoTreinamentoService.buscarParticipacaoTreinamento(participacaoId);
    }

    // @GetMapping("/participacoes-treinamento")
    // public List<ParticipacaoTreinamento> listarParticipacoesTreinamento(){
    //     return participacaoTreinamentoService.buscarParticipacoesTreinamento();
    // }

    @DeleteMapping("/participacoes-treinamento/{participacaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirParticipacaoTreinamento(@PathVariable Long participacaoId){
        participacaoTreinamentoService.excluirParticipacaoTreinamento(participacaoId);
    }

    @PutMapping("/participacoes-treinamento")
    @ResponseStatus(HttpStatus.OK)
    public ParticipacaoTreinamento atualizarParticipacaoTreinamento(@RequestBody ParticipacaoTreinamento participacaoTreinamento){
        return participacaoTreinamentoService.atualizarParticipacaoTreinamento(participacaoTreinamento);
    }
}