package br.com.fiap.esg.dto;

import java.time.LocalDate;

public record TreinamentoDTO(
        Long id,
        String nome,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataFim,
        boolean obrigatorio
) {}