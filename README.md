## 📚 API REST - Sistema de Livraria

### Descrição do projeto

API REST desenvolvida em Java com Spring Boot, que simula um sistema de 
gerenciamento de livraria, com operações de CRUD para livros, autores, 
editoras e gêneros.

### 🔧 Tecnologias utilizadas

- Java
- Spring Boot
- Swagger
- Maven
- MapStruct
- H2 Database
- PostgreSQL
- PgAdmin4
- Insomnia
- Docker

### ⚙️ Ferramentas

- IntelliJ IDEA (Community Edition)
- Git
- GitHub
- Docker Desktop

### 🚀 Funcionalidades

- CRUD completo para livros, autores, editoras e gêneros
- Integração com banco de dados relacional via JPA/Hibernate
- Separação de ambientes de desenvolvimento e produção
- Documentação automática da API via Swagger UI
- Respostas padronizadas com códigos HTTP apropriados

### 🛠️ Configurando o projeto?

#### 1. Pré-requisitos

- Java 17+
- IDE de sua preferência
- Maven instalado
- Insomnia para testes dos endpoints
- Docker Desktop para uso do PostgreSQL e PgAdmin4

#### 2. Clonar o repositório

```
- git clone https://github.com/pedrossjr/livraria.git
- cd livraria-api
``` 

#### 3. Criação do container para uso do PostgreSQL e PgAdmin

```
- cd livraria-api
- docker-compose up -d
``` 

#### 4. Acesse o pgAdmin

- Abra o navegador e acesse:

🔗 http://localhost:5050

- Faça login com as credenciais que definiu no docker-compose:
```
Email: admin@admin.com
Senha: admin
```

#### 5. Registrar um novo servidor

- Na janela de Dashboard, clique em "Add New Server".
- Aba "General"
- Name: Pode ser qualquer nome, ex: PostgreSQL Local
- Aba "Connection"
- Host name/address: postgres
- Port: 5432
- Maintenance database: postgres (ou db_livraria, se já tiver sido criado)
- Username: postgres
- Password: postgres
- Marque a opção "Save Password"
- Clique em Save
 
#### 6. Criar um novo banco de dados

- Após registrar o servidor, expanda ele na lateral esquerda.
- Clique com o botão direito em Databases → Create > Database...
- Database name: ex: db_livraria
- Owner: postgres (ou outro usuário, se quiser)
- Clique em Save

#### 7. Executando a aplicação:

- Execute o projeto com sua IDE de preferência através do botão __Run__ ou na raiz da aplicação, digite o comando abaixo:

```
./mvnw clean spring-boot:run
``` 

### 🛠️ Testando a alicação

#### 1. Aplicação estará disponível em:

🔗 http://localhost:8080

#### 2. Exemplo de Endpoint

#### 📘 Livros

- POST - book/add - Cadastra um novo registro
- GET - book/list - Lista todos os registros
- GET - book/{id}/list - Consulta um registro por Id
- PUT - book/{id}/update - Atualiza um registro existente
- DELETE - book/{id}/delete - Remove um registro

#### 3. PgAdmin estará disponível em 

🔗 http://localhost:5050

#### 4. Documentação Swagger estará disponível em:

🔗 http://localhost:8080/livraria/docs/api

### 🚀 Passos futuros...

- Consultas avançadas a banco de dados.
- Autenticação com JWT.
- Desenvolvimento do frontend para interação com o backend.

### 🙋‍♂️ Contribuição

Fique à vontade para abrir issues ou enviar pull requests. Sugestões e 
melhorias são sempre bem-vindas!