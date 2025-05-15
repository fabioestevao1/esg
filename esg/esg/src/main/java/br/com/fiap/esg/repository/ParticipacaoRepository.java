package br.com.fiap.esg.repository;

import br.com.fiap.esg.model.Participacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipacaoRepository extends JpaRepository<Participacao, Long> {

    @Query("SELECT p FROM Participacao p WHERE p.funcionario.id = :funcionarioId")
    List<Participacao> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

    @Query("SELECT p FROM Participacao p WHERE p.treinamento.id = :treinamentoId")
    List<Participacao> findByTreinamentoId(@Param("treinamentoId") Long treinamentoId);
}