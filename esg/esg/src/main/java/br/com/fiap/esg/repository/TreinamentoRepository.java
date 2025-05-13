package br.com.fiap.esg.repository;

import br.com.fiap.esg.model.Treinamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinamentoRepository extends JpaRepository<Treinamento, Long> {
}
