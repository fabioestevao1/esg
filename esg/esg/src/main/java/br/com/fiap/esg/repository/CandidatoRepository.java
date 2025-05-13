package br.com.fiap.esg.repository;

import br.com.fiap.esg.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}

