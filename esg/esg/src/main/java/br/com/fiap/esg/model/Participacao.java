package br.com.fiap.esg.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_PARTICIPACAO")
public class Participacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARTICIPACAO")
    @SequenceGenerator(name = "SEQ_PARTICIPACAO", sequenceName = "SEQ_PARTICIPACAO", allocationSize = 1)
    @Column(name = "ID_PARTICIPACAO")
    private Long id;

    @Column(name = "data_participacao")
    private LocalDate dataParticipacao;

    private String status;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_treinamento")
    private Treinamento treinamento;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDataParticipacao() { return dataParticipacao; }
    public void setDataParticipacao(LocalDate dataParticipacao) { this.dataParticipacao = dataParticipacao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public Treinamento getTreinamento() { return treinamento; }
    public void setTreinamento(Treinamento treinamento) { this.treinamento = treinamento; }
}