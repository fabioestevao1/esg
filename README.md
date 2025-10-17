# Projeto - ESG

## 🧭 Visão Geral do Projeto

A aplicação **ESG** foi desenvolvida em **Java Spring Boot**, com o objetivo de simular um ambiente corporativo real, aplicando práticas modernas de **DevOps**, como **integração contínua (CI)**, **entrega contínua (CD)**, **containerização** e **deploy automatizado** em múltiplos ambientes (Staging e Produção).

O sistema permite explorar conceitos de sustentabilidade urbana e tecnologia aplicada à gestão corporativa, garantindo processos de build, teste e deploy totalmente automatizados.

---

## 🐳 Como executar localmente com Docker

O projeto utiliza **Docker** e **Docker Compose** para execução local e orquestração dos ambientes.

### Pré-requisitos

* Docker e Docker Compose instalados
* Arquivo `.env` configurado (ou use o `.env.example` como base)

### Passos para execução

1. Baixe o arquivo esg.zip:

   ```bash
   > descompactar
   cd esg
   ```
2. Suba o ambiente de staging:

   ```bash
   docker compose --profile staging up -d
   ```
3. Acesse a aplicação localmente no navegador:
   `http://localhost:8080`

---

## ⚙️ Pipeline CI/CD

O pipeline foi implementado no **Azure DevOps** e segue um fluxo automatizado de integração e entrega contínua.

### 🔄 Etapas do pipeline

1. **Build & Test (Maven)** – compila o projeto e executa testes automatizados.
2. **Docker Build & Push** – gera a imagem Docker e publica no Docker Hub.
3. **Deploy Staging** – realiza o deploy automático em ambiente de testes (Staging).
4. **Deploy Produção** – é acionado automaticamente ao criar uma tag no formato `vX.Y.Z`.

> A cada commit no branch `main`, ocorre build, teste e deploy em **Staging**.
> Ao criar uma **tag**, é disparado o deploy em **Produção**.

### 🧩 Ferramentas e configurações

* **Plataforma:** Azure DevOps
* **Service Connections:** `sc-dockerhub` e `sc-azure`
* **Arquivo de pipeline:** `azure-pipelines.yml`

---

## 📦 Containerização

A aplicação foi containerizada utilizando um **Dockerfile otimizado** baseado em `eclipse-temurin:21-jre-alpine`.

### Exemplo de Dockerfile

```dockerfile
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY target/esg.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "esg.jar"]
```

### Estratégias adotadas

* Imagem leve e otimizada para produção
* Variáveis de ambiente gerenciadas via `.env`
* `docker-compose.yml` com perfis para **Staging** e **Produção**

---

## 🌐 Ambientes de Deploy

| Ambiente     | URL                                                                                                                                                                    | Descrição            |
| ------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------- |
| **Staging**  | [https://esg-app-fiap-staging-heckaecdejczdcb6.canadacentral-01.azurewebsites.net/](https://esg-app-fiap-staging-heckaecdejczdcb6.canadacentral-01.azurewebsites.net/) | Testes e homologação |
| **Produção** | [https://esg-app-fiap.canadacentral-01.azurewebsites.net/](https://esg-app-fiap.canadacentral-01.azurewebsites.net/)                                                   | Ambiente final       |

---

## 📸 Evidências do Funcionamento

* ✅ Pipeline “Staging” concluído com sucesso
* 🚀 Pipeline “Produção” concluído com sucesso
* ☁️ Azure App Service com slots configurados
* 🐋 Docker Hub com imagem publicada
* 💻 Aplicação em execução e acessível nos ambientes listados


> Prints de Funcionamento estão no .pdf

---

## 🧠 Desafios e Soluções

| Desafio                               | Solução                                                                |
| ------------------------------------- | ---------------------------------------------------------------------- |
| Falha de login no Docker Hub          | Criação da Service Connection `sc-dockerhub` com token válido          |
| Erro “Parameter name cannot be empty” | Separação das App Settings em task própria antes do deploy             |
| Erro de deploy ZIP                    | Utilização do tipo `webAppContainer` para deploy de imagem Docker      |
| Falta de variáveis locais             | Criação dos arquivos `.env` e `.env.example` para execução via Compose |

---

## 🧰 Tecnologias Utilizadas

* **Linguagem:** Java (Spring Boot)
* **Banco de Dados:** Oracle (FIAP)
* **Containerização:** Docker e Docker Compose
* **CI/CD:** Azure DevOps
* **Deploy:** Azure App Service
* **Versionamento:** Git / GitHub

---

## 🏁 Conclusão

O projeto **Cidades ESGInteligentes** demonstra domínio prático dos princípios de **DevOps**, integrando automação de build, testes, containerização e deploy em nuvem com versionamento completo.

A entrega consolida um fluxo profissional de desenvolvimento contínuo, com foco em escalabilidade, qualidade e sustentabilidade tecnológica.

---

**Integrantes:**

* Fábio Estevão – RM: 554717
* Marcus Silva – RM: 557159
* Bruno Henrique – RM: 555108
  **Turma:** 2TDSOD
