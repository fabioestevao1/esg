# 🌱 ESG Application – DevOps Pipeline (Java Spring)

## 👥 Integrantes
- **Bruno Henrique**
- **Fábio Estevão**
- **Marcus Silva**

---

## 🧩 Descrição do Projeto
Aplicação desenvolvida em **Java Spring Boot** com o tema ESG (Environmental, Social and Governance).  
O projeto foi aprimorado para incluir um **pipeline DevOps completo**, com **CI/CD, containerização, orquestração e deploy automatizado** em ambientes *staging* e *produção* na **Azure**.

---

## ⚙️ Tecnologias Utilizadas
- **Java 21 (Spring Boot)**
- **Maven**
- **Docker / Docker Compose**
- **Azure DevOps Pipelines**
- **Azure App Service (Linux Containers)**
- **Oracle Database (FIAP)**

---

## 🚀 Estrutura de Ambientes

| Ambiente | URL | Descrição |
|-----------|-----|------------|
| **Staging** | [https://esg-app-fiap-staging-heckaecdejczdcb6.canadacentral-01.azurewebsites.net](https://esg-app-fiap-staging-heckaecdejczdcb6.canadacentral-01.azurewebsites.net) | Testes e validações |
| **Produção** | [https://esg-app-fiap.canadacentral-01.azurewebsites.net](https://esg-app-fiap.canadacentral-01.azurewebsites.net) | Ambiente principal |

---

## 🧱 Arquitetura do Pipeline (CI/CD)

```mermaid
flowchart LR
A[Commit no branch main] --> B[Pipeline Build/Test]
B --> C[Docker Build & Push no Docker Hub]
C --> D[Deploy automático em Staging]
D -->|Tag v* criada| E[Deploy automático em Produção]
