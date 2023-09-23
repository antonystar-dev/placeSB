
# Marca e modelo

Criei o Projeto com **Spring Boot** utilizando o gerenciador de dependencias **Maven**.
Utilizei as seguintes dependencias:
* Spring Boot DevTools
* Spring Web
* Spring Data JPA
* H2 Database
* mysql Driver

Apos encontrar algumas incompatibilidades com o banco optei em descartar o **H2 Database** e utilizar o **Mysql**.
## CRIAR O BANCO DE DADOS
Para realizar o teste, executar o seguinte SQL:
```
CREATE DATABASE placebd;
USE placebd;

-- Tabela para a entidade Marca
CREATE TABLE marca (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo_denatran VARCHAR(255),
    ativo VARCHAR(255) NULL
);

-- Tabela para a entidade Modelo
CREATE TABLE modelo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    ano INT NULL,
    ativo VARCHAR(255) null,
    marca_id BIGINT,
    FOREIGN KEY (marca_id) REFERENCES marca (id)
);

```

Apos o cadastro do banco de dados, inserir primeiro os dados das Marcas dos carros.

Realizei o POST, GET, PUT e DELETE pelo **Postman**

Segue os codigos JSON para interação:

## MARCA (entidade)

JSON para Adicionar Marca:

http://localhost:8080/marca
```
{
  "nome": "Marca do veiculo",
  "codigo_denatran": "codigo",
  "ativo": "situacao"
}
```
JSON para Listar Marca:

Não se aplica, mas consultar da seguinte forma:

Listar todas as marcas= http://localhost:8080/marca 
Listar marcas separadas= http://localhost:8080/marca/id

JSON para Alterar Marca:

http://localhost:8080/marca/id
```
{
  "nome": "Marca do veiculo",
  "codigo_denatran": "codigo",
  "ativo": "situacao"
}
```
JSON para Excluir Marca:

Não se aplica, mas excluir da seguinte forma:
http://localhost:8080/marca/id


## MODELO

JSON para adicionar modelo:
http://localhost:8080/modelo

Passar o ID da marca sem Aspas
```
{
	"nome": "nome do modelo",
	"ano":2023,
	"ativo":"situacao",
    "marca":{
        "id":id do modelo
        }
   
}
```
JSON para Listar Modelo:

Não se aplica, mas consultar da seguinte forma:

Listar todos os modelos= http://localhost:8080/modelo 
Listar modelo separado= http://localhost:8080/modelo/id

JSON para Alterar Modelo:
http://localhost:8080/modelo/id

Passar o ID da marca sem Aspas
```
{
	"nome": "nome do modelo",
	"ano":2023,
	"ativo":"situacao",
    "marca":{
        "id":id do modelo
        }
   
}
```
JSON para Excluir Modelo:

Não se aplica, mas excluir da seguinte forma:
http://localhost:8080/modelo/id