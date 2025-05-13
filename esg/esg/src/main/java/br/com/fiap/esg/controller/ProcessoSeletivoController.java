
package br.com.fiap.esg.controller;

import br.com.fiap.esg.model.ProcessoSeletivo;
import br.com.fiap.esg.service.ProcessoSeletivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// import java.util.List; // Descomente se for usar o método de listar todos

@RestController
@RequestMapping("/api")
public class ProcessoSeletivoController {

    @Autowired
    private ProcessoSeletivoService processoSeletivoService;

    @PostMapping("/processos-seletivos")
    @ResponseStatus(HttpStatus.CREATED)
    public ProcessoSeletivo adicionarProcessoSeletivo(@RequestBody ProcessoSeletivo processoSeletivo){
        return processoSeletivoService.salvarProcessoSeletivo(processoSeletivo);
    }

    @GetMapping("/processos-seletivos/{processoId}") // Usando {processoId} conforme o ID da entidade
    public ProcessoSeletivo buscarProcessoSeletivo(@PathVariable Long processoId){
        return processoSeletivoService.buscarProcessoSeletivo(processoId);
    }

    // @GetMapping("/processos-seletivos")
    // public List<ProcessoSeletivo> listarProcessosSeletivos(){
    //     return processoSeletivoService.buscarProcessosSeletivos();
    // }

    @DeleteMapping("/processos-seletivos/{processoId}") // Usando {processoId}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirProcessoSeletivo(@PathVariable Long processoId){
        processoSeletivoService.excluirProcessoSeletivo(processoId);
    }

    @PutMapping("/processos-seletivos")
    @ResponseStatus(HttpStatus.OK)
    public ProcessoSeletivo atualizarProcessoSeletivo(@RequestBody ProcessoSeletivo processoSeletivo){
        return processoSeletivoService.atualizarProcessoSeletivo(processoSeletivo);
    }
}