-- Reinicia as SEQUENCES para garantir que os primeiros registros tenham ID 1 e 2
ALTER SEQUENCE SEQ_FUNCIONARIOS RESTART START WITH 1;
ALTER SEQUENCE SEQ_TREINAMENTOS RESTART START WITH 1;
ALTER SEQUENCE SEQ_PROCESSOS_SELETIVOS RESTART START WITH 1;
ALTER SEQUENCE SEQ_CANDIDATOS RESTART START WITH 1;


INSERT INTO tbl_funcionarios (nome, email, telefone, idade, genero, etnia, setor, cargo, data_admissao)
VALUES ('João da Silva', 'joao@empresa.com', '(11) 90000-0001', 35, 'Masculino', 'Pardo', 'Tecnologia', 'Desenvolvedor', TO_DATE('2023-05-01', 'YYYY-MM-DD'));

INSERT INTO tbl_funcionarios (nome, email, telefone, idade, genero, etnia, setor, cargo, data_admissao)
VALUES ('Ana Oliveira', 'ana@empresa.com', '(11) 90000-0002', 29, 'Feminino', 'Negra', 'RH', 'Analista de Inclusão', TO_DATE('2022-08-15', 'YYYY-MM-DD'));

INSERT INTO tbl_treinamentos (nome, descricao, data_inicio, data_fim, obrigatorio)
VALUES ('Diversidade nas Empresas', 'Inclusão e respeito no trabalho', TO_DATE('2024-01-10', 'YYYY-MM-DD'), TO_DATE('2024-01-12', 'YYYY-MM-DD'), 'S');

INSERT INTO tbl_treinamentos (nome, descricao, data_inicio, data_fim, obrigatorio)
VALUES ('Comunicação Não-Violenta', 'Oficina de empatia', TO_DATE('2024-03-05', 'YYYY-MM-DD'), TO_DATE('2024-03-06', 'YYYY-MM-DD'), 'N');

INSERT INTO tbl_processos_seletivos (setor, numero_candidatos, numero_fases, aprovados)
VALUES ('Tecnologia', 10, 3, 2);

INSERT INTO tbl_processos_seletivos (setor, numero_candidatos, numero_fases, aprovados)
VALUES ('RH', 5, 2, 1);

INSERT INTO tbl_candidatos (nome, email, telefone, idade, genero, etnia, fase, status)
VALUES ('Carlos Mendes', 'carlos@exemplo.com', '(11) 91111-1111', 26, 'Masculino', 'Indígena', 'Currículo', 'Em análise');

INSERT INTO tbl_candidatos (nome, email, telefone, idade, genero, etnia, fase, status)
VALUES ('Juliana Souza', 'juliana@exemplo.com', '(11) 92222-2222', 31, 'Feminino', 'Negra', 'Entrevista', 'Aprovada');

-- Assumindo que os IDs de funcionários e treinamentos inseridos acima são 1 e 2
INSERT INTO tbl_participacao (data_participacao, status, id_funcionario, id_treinamento)
VALUES (TO_DATE('2024-01-11', 'YYYY-MM-DD'), 'Concluído', 1, 1);

INSERT INTO tbl_participacao (data_participacao, status, id_funcionario, id_treinamento)
VALUES (TO_DATE('2024-03-06', 'YYYY-MM-DD'), 'Pendente', 2, 2);

INSERT INTO tbl_processo_candidatos (fase_atual, status, id_candidato, id_processo)
VALUES ('Entrevista', 'Em andamento', 1, 1);

INSERT INTO tbl_processo_candidatos (fase_atual, status, id_candidato, id_processo)
VALUES ('Final', 'Aprovado', 2, 2);