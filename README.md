# Proof Of Concept: Quarkus with Panache and Mapstruct

This project uses Quarkus Framework, RestEasy and RestClient Microprofiles, Hibernate Panache with H2 database and Mapstruct to convert DTO to Entity and vice-versa 

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```
## Usage

Just call a GET for the URL (can use web browser)
```shell script
http://localhost:8080/address/{CEP}
```
The CEP variable is the Brazillian postal code and can be found here https://buscacepinter.correios.com.br/app/endereco/index.php

Try this example http://localhost:8080/address/88010400 and receive this response "Praça Quinze de Novembro - Centro - Florianópolis - SC"
