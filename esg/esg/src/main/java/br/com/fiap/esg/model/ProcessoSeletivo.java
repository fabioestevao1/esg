package br.com.fiap.esg.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_processos_seletivos")
@Data
public class ProcessoSeletivo {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROCESSOS_SELETIVOS")
    @SequenceGenerator(name = "SEQ_PROCESSOS_SELETIVOS", sequenceName = "SEQ_PROCESSOS_SELETIVOS", allocationSize = 1)
    @Column(name = "idProcesso")
    private Long idProcesso;
    private String setor;
    private Integer numeroCandidatos;
    private Integer numeroFases;
    private Integer aprovados;
}
