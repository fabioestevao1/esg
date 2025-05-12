package br.com.fiap.esg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table (name = "tbl_treinamentos")
@Data
public class Treinamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TREINAMENTOS")
    @SequenceGenerator(name = "SEQ_TREINAMENTOS", sequenceName = "SEQ_TREINAMENTOS", allocationSize = 1)
    @Column(name = "idTreinamento")
    private String idTreinamento;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String obrigatorio;
}
