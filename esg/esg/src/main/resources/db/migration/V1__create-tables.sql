-- SEQUENCES
CREATE SEQUENCE SEQ_FUNCIONARIOS START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_TREINAMENTOS START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_PARTICIPACAO START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

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

CREATE TABLE tbl_participacao (
    id_participacao NUMBER DEFAULT SEQ_PARTICIPACAO.nextval PRIMARY KEY,
    data_participacao DATE,
    status VARCHAR2(40),
    id_funcionario NUMBER,
    id_treinamento NUMBER,
    CONSTRAINT fk_participacao_funcionario FOREIGN KEY (id_funcionario) REFERENCES tbl_funcionarios(id_funcionario),
    CONSTRAINT fk_participacao_treinamento FOREIGN KEY (id_treinamento) REFERENCES tbl_treinamentos(id_treinamento)
);
