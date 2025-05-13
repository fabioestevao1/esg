package br.com.fiap.esg.repository;

import br.com.fiap.esg.model.ProcessoCandidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoCandidatoRepository extends JpaRepository<ProcessoCandidato, Long> {
}
