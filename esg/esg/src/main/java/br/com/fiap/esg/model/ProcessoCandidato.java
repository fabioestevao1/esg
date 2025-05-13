package br.com.fiap.esg.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_processo_candidatos")
@Data
public class ProcessoCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROCESSO_CANDIDATOS")
    @SequenceGenerator(name = "SEQ_PROCESSO_CANDIDATOS", sequenceName = "SEQ_PROCESSO_CANDIDATOS", allocationSize = 1)
    @Column(name = "idProcessoCandidato")
    private Long idProcessoCandidato;
    private String faseAtual;
    private String status;
}
