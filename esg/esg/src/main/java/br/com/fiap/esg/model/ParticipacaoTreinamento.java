package br.com.fiap.esg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_participacao")
@Data
public class ParticipacaoTreinamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARTICIPACAO")
    @SequenceGenerator(name = "SEQ_PARTICIPACAO", sequenceName = "SEQ_PARTICIPACAO", allocationSize = 1)
    @Column(name = "idParticipacao")
    private Long idParticipacao;
    private LocalDate dataParticipacao;
    private String status;
}
