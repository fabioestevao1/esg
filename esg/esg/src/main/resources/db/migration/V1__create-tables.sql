-- SEQUENCES
CREATE SEQUENCE SEQ_FUNCIONARIOS START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_TREINAMENTOS START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_PROCESSOS_SELETIVOS START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_CANDIDATOS START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_PARTICIPACAO START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_PROCESSO_CANDIDATOS START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- TABELAS
CREATE TABLE tbl_funcionarios (
    id_funcionario NUMBER DEFAULT SEQ_FUNCIONARIOS.nextval PRIMARY KEY,
    nome VARCHAR2(40),
    email VARCHAR2(40),
    senha VARCHAR2(20),
    telefone VARCHAR2(40),
    idade NUMBER,
    genero VARCHAR2(40),
    etnia VARCHAR2(40),
    setor VARCHAR2(40),
    cargo VARCHAR2(40),
    data_admissao DATE
);

CREATE TABLE tbl_treinamentos (
    id_treinamento NUMBER DEFAULT SEQ_TREINAMENTOS.nextval PRIMARY KEY,
    nome VARCHAR2(40),
    descricao VARCHAR2(40),
    data_inicio DATE,
    data_fim DATE,
    obrigatorio CHAR(1) CONSTRAINT chk_treinamento_obrigatorio CHECK (obrigatorio IN ('S', 'N'))
);

CREATE TABLE tbl_processos_seletivos (
    id_processo NUMBER DEFAULT SEQ_PROCESSOS_SELETIVOS.nextval PRIMARY KEY,
    setor VARCHAR2(40),
    numero_candidatos NUMBER,
    numero_fases NUMBER,
    aprovados NUMBER
);

CREATE TABLE tbl_candidatos (
    id_candidato NUMBER DEFAULT SEQ_CANDIDATOS.nextval PRIMARY KEY,
    nome VARCHAR2(40),
    email VARCHAR2(40),
    telefone VARCHAR2(40),
    idade NUMBER,
    genero VARCHAR2(40),
    etnia VARCHAR2(40),
    fase VARCHAR2(40),
    status VARCHAR2(40)
);

CREATE TABLE tbl_participacao (
    id_participacao NUMBER DEFAULT SEQ_PARTICIPACAO.nextval PRIMARY KEY,
    data_participacao DATE,
    status VARCHAR2(40),
    id_funcionario NUMBER,
    id_treinamento NUMBER,
    CONSTRAINT fk_participacao_funcionario FOREIGN KEY (id_funcionario) REFERENCES tbl_funcionarios(id_funcionario),
    CONSTRAINT fk_participacao_treinamento FOREIGN KEY (id_treinamento) REFERENCES tbl_treinamentos(id_treinamento)
);

CREATE TABLE tbl_processo_candidatos (
    id_processo_candidato NUMBER DEFAULT SEQ_PROCESSO_CANDIDATOS.nextval PRIMARY KEY,
    fase_atual VARCHAR2(40),
    status VARCHAR2(40),
    id_candidato NUMBER,
    id_processo NUMBER,
    CONSTRAINT fk_proc_cand_candidato FOREIGN KEY (id_candidato) REFERENCES tbl_candidatos(id_candidato),
    CONSTRAINT fk_proc_cand_processo FOREIGN KEY (id_processo) REFERENCES tbl_processos_seletivos(id_processo)
);
