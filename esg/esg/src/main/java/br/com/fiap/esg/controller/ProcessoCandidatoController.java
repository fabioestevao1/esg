
package br.com.fiap.esg.controller;

import br.com.fiap.esg.model.ProcessoCandidato;
import br.com.fiap.esg.service.ProcessoCandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// import java.util.List; // Descomente se for usar o método de listar todos

@RestController
@RequestMapping("/api")
public class ProcessoCandidatoController {

    @Autowired
    private ProcessoCandidatoService processoCandidatoService;

    @PostMapping("/processos-candidato")
    @ResponseStatus(HttpStatus.CREATED)
    public ProcessoCandidato adicionarProcessoCandidato(@RequestBody ProcessoCandidato processoCandidato){
        return processoCandidatoService.salvarProcessoCandidato(processoCandidato);
    }

    @GetMapping("/processos-candidato/{processoCandidatoId}")
    public ProcessoCandidato buscarProcessoCandidato(@PathVariable Long processoCandidatoId){
        return processoCandidatoService.buscarProcessoCandidato(processoCandidatoId);
    }

    // @GetMapping("/processos-candidato")
    // public List<ProcessoCandidato> listarProcessosCandidato(){
    //     return processoCandidatoService.buscarProcessosCandidato();
    // }

    @DeleteMapping("/processos-candidato/{processoCandidatoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirProcessoCandidato(@PathVariable Long processoCandidatoId){
        processoCandidatoService.excluirProcessoCandidato(processoCandidatoId);
    }

    @PutMapping("/processos-candidato")
    @ResponseStatus(HttpStatus.OK)
    public ProcessoCandidato atualizarProcessoCandidato(@RequestBody ProcessoCandidato processoCandidato){
        return processoCandidatoService.atualizarProcessoCandidato(processoCandidato);
    }
}