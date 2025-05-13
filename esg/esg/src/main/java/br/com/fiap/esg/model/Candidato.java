package br.com.fiap.esg.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_candidatos")
@Data
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CANDIDATOS")
    @SequenceGenerator(name = "SEQ_CANDIDATOS", sequenceName = "SEQ_CANDIDATOS", allocationSize = 1)
    @Column(name = "idCandidato")
    private Long idCandidato;
    private String nome;
    private String email;
    private String telefone;
    private Integer idade;
    private String genero;
    private String etnia;
    private String fase;
    private String status;

}
