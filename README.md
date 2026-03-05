# Sistema de Consulta de Medicamentos

Este é um projeto desktop desenvolvido em Java para auxiliar na consulta de medicamentos recomendados com base em sintomas. O sistema possui um fluxo completo de autenticação e busca, com uma interface gráfica personalizada.

## Funcionalidades

- **Autenticação:** Sistema de Login e Cadastro de novos usuários.
- **Persistência de Dados:** Armazenamento de usuários em arquivos locais (.txt).
- **Consulta de Sintomas:** Busca de medicamentos e intervalos de horários recomendados.
- **Interface Gráfica (GUI):** Telas personalizadas com gradientes e componentes Swing.
- **Gerenciamento de Sessão:** Função de Logout para retornar à tela inicial de acesso.

## Tecnologias Utilizadas

- **Linguagem:** Java
- **Biblioteca Gráfica:** Java Swing
- **Arquitetura:** Camadas (Model, Service, View)
- **Versionamento:** Git e GitHub

## Estrutura do Projeto

- `src/model`: Classes de entidade (Usuário, Medicamento).
- `src/service`: Lógica de negócio e manipulação de arquivos.
- `src/view`: Telas da interface (Login, Cadastro, Principal).
- `resources`: Ícones e recursos visuais do sistema.

## Como executar o projeto

1. Tenha o JDK instalado em sua máquina.
2. Clone este repositório.
3. Abra o projeto no VS Code ou em sua IDE de preferência.
4. Execute a classe principal (`TelaLogin.java`).

---
Desenvolvido por Felype Albuquerque