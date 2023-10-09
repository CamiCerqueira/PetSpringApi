PetSpringApi

Idealizadoras: Camila Cerqueira, Felicianne Costa e Raquel Caroline Thiengo (Trilha Java Ada Tech)

O PetSpringApi é um projeto de API Rest desenvolvido para um e-commerce de petshop que oferece serviços e produtos. O projeto foi desenvolvido como parte do módulo de API Rest do Woman<dev> #btgfaztech.

Requisitos

O projeto deve atender aos seguintes requisitos:

Implementar o endpoint de CRUD de costumer, leitura dos costumers cadastrados, atualização de informações e deleção do costumer.
As informações geradas devem permitir o acesso a aplicação via login e autenticação via token.
Alguns endpoints de buscas devem receber filtros opcionais e realizar consultas na camada de dados.


Implementação

O projeto foi implementado usando as seguintes tecnologias:

Java
Spring Boot
JPA
Hibernate
H2


Arquitetura

O projeto segue a arquitetura de microsserviços, com cada entidade sendo representada por uma API Rest.


Endpoints

Os endpoints implementados são os seguintes:

Customer:
POST /customer: cria um novo cliente
GET /customer: lista todos os clientes
GET /customer/{id}: busca um cliente pelo ID
PUT /customer/{id}: atualiza as informações de um cliente
DELETE /customer/{id}: deleta um cliente

Pet:
POST /pet: cria um novo pet
GET /pet/{id}: busca um pet pelo ID
PUT /pet/{id}: atualiza as informações de um pet
DELETE /pet/{id}: deleta um pet

Product:
POST /product: cria um novo produto
GET /product: lista todos os produtos
GET /product/{id}: busca um produto pelo ID
PUT /product/{id}: atualiza as informações de um produto
DELETE /product/{id}: deleta um produto

TypeProductService:
POST /typeProductService: cria um novo tipo de serviço
GET /typeProductService: lista todos os tipos de serviços
GET /typeProductService/{id}: busca um tipo de serviço pelo ID
PUT /typeProductService/{id}: atualiza as informações de um tipo de serviço
DELETE /typeProductService/{id}: deleta um tipo de serviço

PetService:
POST /petService: cria um novo serviço
GET /petService: lista todos os serviços
DELETE /petService/{id}: deleta um serviço pelo ID


Futuro

O projeto ainda está em desenvolvimento e os seguintes itens estão previstos para serem implementados no futuro:

Refinamento dos endpoints de UserEmployee.
Implementação de testes unitários e de integração.


Conclusão

O PetSpringApi é um projeto de API Rest que atende aos requisitos especificados. O projeto está em desenvolvimento e novos recursos serão implementados no futuro.

