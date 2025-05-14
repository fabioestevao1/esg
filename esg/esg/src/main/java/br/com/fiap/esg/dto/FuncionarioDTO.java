package br.com.fiap.esg.dto;

import java.time.LocalDate;

public record FuncionarioDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        Integer idade,
        String genero,
        String etnia,
        String setor,
        String cargo,
        LocalDate dataAdmissao
){}