package br.com.fiap.esg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "TBL_TREINAMENTOS")
public class Treinamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TREINAMENTOS")
    @SequenceGenerator(name = "SEQ_TREINAMENTOS", sequenceName = "SEQ_TREINAMENTOS", allocationSize = 1)
    @Column(name = "ID_TREINAMENTO")
    private Long id;

    private String nome;
    private String descricao;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    private Character obrigatorio;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public Character getObrigatorio() { return obrigatorio; }
    public void setObrigatorio(Character obrigatorio) { this.obrigatorio = obrigatorio; }

    // Método conveniente para boolean
    public boolean isObrigatorio() {
        return obrigatorio != null && obrigatorio.equals('S');
    }
}
