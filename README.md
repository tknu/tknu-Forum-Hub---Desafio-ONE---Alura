

# Fórum Hub API

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.1-brightgreen)
![Maven](https://img.shields.io/badge/Maven-4.0.0-red)
![Status](https://img.shields.io/badge/Status-Concluído-green)

## 📖 Sobre o Projeto

**Fórum Hub** é uma API RESTful desenvolvida como parte do programa **ONE (Oracle Next Education)** em parceria com a **Alura Latam**. O objetivo deste desafio foi construir o back-end de uma plataforma de fórum, similar ao da Alura, onde os usuários podem postar dúvidas, interagir e aprender de forma colaborativa.

A API implementa um CRUD completo para **Tópicos** e um sistema de autenticação e autorização seguro utilizando **Tokens JWT**, garantindo que apenas usuários autenticados possam criar, alterar ou deletar conteúdo.

Este projeto foi uma oportunidade incrível para aplicar conceitos avançados de desenvolvimento back-end com Java e o ecossistema Spring, incluindo:
-   Arquitetura REST e boas práticas de design de APIs.
-   Segurança com Spring Security e autenticação stateless.
-   Persistência de dados com Spring Data JPA e versionamento de banco com Flyway.
-   Validação de dados e tratamento de erros de forma centralizada.
-   Documentação de API interativa com SpringDoc OpenAPI (Swagger).

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:
-   **Java 17:** Versão LTS do Java, garantindo robustez e acesso a recursos modernos da linguagem.
-   **Spring Boot 3:** Framework principal para a criação da aplicação, simplificando a configuração e o desenvolvimento.
-   **Spring Web:** Para a construção de endpoints RESTful.
-   **Spring Data JPA:** Para a persistência de dados e abstração do acesso ao banco de dados.
-   **Spring Security:** Para a implementação da camada de autenticação e autorização.
-   **Maven:** Gerenciador de dependências e build do projeto.
-   **MySQL:** Banco de dados relacional para armazenamento dos dados.
-   **Flyway:** Ferramenta para versionamento e migração do schema do banco de dados.
-   **Lombok:** Para reduzir o código boilerplate (getters, setters, construtores).
-   **JWT (JSON Web Token):** Para a geração de tokens de acesso stateless.
-   **SpringDoc OpenAPI (Swagger):** Para a documentação interativa da API.

---

## ⚙️ Funcionalidades Implementadas

A API do Fórum Hub oferece os seguintes endpoints:

### 1. Autenticação
-   `POST /login`: Permite que um usuário se autentique enviando seu login e senha, recebendo um token JWT em troca.

### 2. Tópicos (CRUD)
*(Todos os endpoints de Tópicos requerem um token JWT válido no cabeçalho `Authorization`)*
-   `POST /topicos`: Cria um novo tópico no fórum.
-   `GET /topicos`: Lista todos os tópicos ativos de forma paginada.
-   `GET /topicos/{id}`: Detalha um tópico específico pelo seu ID.
-   `PUT /topicos/{id}`: Atualiza o título e/ou a mensagem de um tópico existente.
-   `DELETE /topicos/{id}`: Realiza uma exclusão lógica de um tópico, marcando-o como inativo.

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar a API em seu ambiente local.

### Pré-requisitos
-   Java JDK 17 ou superior.
-   Maven 3.8 ou superior.
-   MySQL 8 ou superior.
-   Um cliente de API como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/).

### Passos
1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/tknu/Forum-Hub---Desafio-ONE---Alura-main.git
    cd Forum-Hub---Desafio-ONE---Alura-main
    ```

2.  **Crie o banco de dados:**
    -   Abra seu cliente MySQL e crie um novo banco de dados.
      ```sql
      CREATE DATABASE forumhub_db;
      ```

3.  **Configure as variáveis de ambiente:**
    -   No arquivo `src/main/resources/application.properties`, configure as variáveis de acesso ao seu banco de dados:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/forumhub_db
      spring.datasource.username=seu_usuario_mysql
      spring.datasource.password=sua_senha_mysql
      ```
    -   Configure também o segredo do JWT (recomenda-se usar uma variável de ambiente em produção):
      ```properties
      api.security.token.secret=seu_segredo_super_forte_aqui
      ```

4.  **Execute a aplicação:**
    -   Abra o projeto em sua IDE preferida (ex: IntelliJ, VSCode).
    -   Execute a classe principal `ApiApplication.java`.
    -   O Flyway irá criar e popular as tabelas automaticamente na primeira execução.

5.  **Acesse a documentação:**
    -   Com a aplicação rodando, acesse a documentação interativa no seu navegador:
      [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
    -   Você pode usar a UI do Swagger para testar todos os endpoints.

---

## 🔮 Próximos Passos (Evolução do Projeto)

Este projeto tem uma base sólida que pode ser expandida com novas funcionalidades. Algumas ideias para os próximos passos incluem:

-   **Implementar a rota `/respostas`:**
    -   `POST /topicos/{id}/respostas`: Adicionar uma nova resposta a um tópico.
    -   `PUT /respostas/{id}`: Editar uma resposta.
    -   `DELETE /respostas/{id}`: Excluir uma resposta.
-   **Implementar a rota `/usuarios`:**
    -   `POST /usuarios`: Permitir o cadastro de novos usuários diretamente pela API.
    -   `GET /usuarios/{id}`: Visualizar o perfil de um usuário.
-   **Melhorar o relacionamento entre entidades:**
    -   Fazer a associação real entre `Topico` e `Usuario` usando chaves estrangeiras, em vez de salvar o nome do autor como uma String.
-   **Implementar o sistema de perfis/roles (roles):**
    -   Diferenciar permissões entre usuários comuns e moderadores.

---

## 🤝 Agradecimentos

Este projeto foi desenvolvido como parte do **Challenge Back-End** do programa **Oracle Next Education**.

Agradeço à **[@Oracle-Next-Education](https://github.com/Oracle-Next-Education)** e à **[@Alura](https://github.com/alura)** pela oportunidade de aprendizado e pelo desafio proposto.

---

## 👨‍💻 Autor

**Thiago Ueda**

-   **GitHub:** [@tknu](https://github.com/tknu)
-   **LinkedIn:** [thiago-ueda-dev](https://www.linkedin.com/in/thiago-ueda-dev/)

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/thiago-ueda-dev/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/tknu)
