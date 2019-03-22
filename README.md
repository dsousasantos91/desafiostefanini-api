# Desafio Stefanini

API criada para realização de cadastro de pessoas e seus respectivo endereços. Por via de regra um pessoa pode possuir vários endereço (1 para muitos) e enderço apenas para uma pessoa (muitos para 1). Nesta API foram implementadas as funções de criar, obter, atualizar e apagar pessoas e seus endereços. Para endereço foi atribuido uma propriedade para validar se endereço esta ativo ou inativo, assim na buscar por pessoa apenas o endereços ativos serão listados.

## Começando

Para iniciar o projeto basta clonar o repositório para máquina e seguir o processo de instalação deste arquivo.

## Pré-requisitos
```
JDK 8
IDE Spring Tools Suite ou Intellij (preferencialmente)
```

## Instalação
Importe o projeto em sua IDE de preferência e execute os comandos Maven clean e install. Após, basta executar a classe principal do projeto que por usar Spring Boot trabalha com um Tomcat embargado.
```
mvn clean
mvn install
```
ou
```
mvn clean install -U -DskipTests
```

## Autor
```
Douglas de Sousa Santos 
dsousasantos91@gmail.com 
```

## Regra
```
POST /api/pessoa com valores faltando retornar status de requisição inválida - HTTP Status 400
POST /api/pessoa ao executar retornar status de criação e com location no header - HTTP Status 201, Location no header
GET /api/pessoa ao executar retornar status de ok - HTTP Status 200
GET /api/pessoa/{id} com id válido retornar objeto pessoa detalhado e status ok- Objeto Pessoa e HTTP status 200
GET /api/pessoa/{id}  com id  inválido retorna status de não encontrado - HTTP Status 404
DELETE /api/pessoa/{id} com id válido retorna o status de nenhum conteúdo - No Content 204
DELETE /api/pessoa/{id} com id inválido retorna o status não encontrado - HTTP Status 404
PUT /api/pessoa/{id} com id válido pode realizar alteração no objeto endereco- HTTP Status 200
GET /api/endereco ao executar retornar status de ok - HTTP Status 200
GET /api/endereco/{id} com id válido retornar objeto endereco e status ok- Objeto Pessoa e HTTP status 200
PUT /api/endereco/{id} com id válido pode realizar alteração no objeto endereco- HTTP Status 200
DELETE /api/endereco/{id} com id válido retorna o status de nenhum conteúdo - No Content 204
PUT /api/endereco/{id}/ativo com id válido pode realizar alteração no objeto endereco- HTTP Status 200
```

## Tecnologias usadas na construção da API Rest:
```
Java 8
Spring Boot
Spring Data
Maven
H2
Flyway
Swagger
MapStruct
```
