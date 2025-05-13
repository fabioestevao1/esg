
package br.com.fiap.esg.controller;

import br.com.fiap.esg.model.Treinamento;
import br.com.fiap.esg.service.TreinamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// import java.util.List; // Descomente se for usar o método de listar todos

@RestController
@RequestMapping("/api")
public class TreinamentoController {

    @Autowired
    private TreinamentoService treinamentoService;

    @PostMapping("/treinamentos")
    @ResponseStatus(HttpStatus.CREATED)
    public Treinamento adicionarTreinamento(@RequestBody Treinamento treinamento){
        return treinamentoService.salvarTreinamento(treinamento);
    }

    @GetMapping("/treinamentos/{treinamentoId}")
    public Treinamento buscarTreinamento(@PathVariable Long treinamentoId){
        return treinamentoService.buscarTreinamento(treinamentoId);
    }

    // @GetMapping("/treinamentos")
    // public List<Treinamento> listarTreinamentos(){
    //     return treinamentoService.buscarTreinamentos();
    // }

    @DeleteMapping("/treinamentos/{treinamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTreinamento(@PathVariable Long treinamentoId){
        treinamentoService.excluirTreinamento(treinamentoId);
    }

    @PutMapping("/treinamentos")
    @ResponseStatus(HttpStatus.OK)
    public Treinamento atualizarTreinamento(@RequestBody Treinamento treinamento){
        return treinamentoService.atualizarTreinamento(treinamento);
    }
}