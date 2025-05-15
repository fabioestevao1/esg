package br.com.fiap.esg.dto;

import java.time.LocalDate;

public record ParticipacaoDTO(
        Long id,
        LocalDate dataParticipacao,
        String status,
        Long funcionarioId,
        Long treinamentoId,
        String funcionarioNome,
        String treinamentoNome
) {}
