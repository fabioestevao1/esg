package br.com.fiap.esg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_funcionarios")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIOS")
    @SequenceGenerator(name = "SEQ_FUNCIONARIOS", sequenceName = "SEQ_FUNCIONARIOS", allocationSize = 1)
    @Column(name = "idFuncionario")
    private Long idFuncionario;
    private String nome;
    private String email;
    private String telefone;
    private Integer idade;
    private String genero;
    private String etnia;
    private String setor;
    private String cargo;
    private LocalDate dataAdmissao;
}
