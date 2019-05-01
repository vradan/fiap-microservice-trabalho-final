# Statistics Service REST API
  Este serviço REST foi construído com spring-boot e tem como objetivo servir com uma API de estatística. Os métodos implementados são POST para salvar uma transação e GET para retornar uma estatística das transações dos últimos 60 segundos.

POST
------
Para criar uma nova transação, é necessário passar um valor double, que representa o valor total da transação, e um long que representa a data no formato unix em milissegundos.

###### Endpoint: [http://localhost:8080/transaction/](http://localhost:8080/transaction/)

###### body:
```json
{
  "amount": 2424,
  "timestamp": 1556675414059
}
```

###### response 201: se criado com sucesso
###### response 204: se o timestamp informado aconteceu a mais de 60s do momento ta inserção.
###### response 400: caso não seja passado body ou um dos campos estejam vazios.

GET
------
A API faz o cálculo com as transações que ocorrorem em até 60s anteriores a requisição. Devolve um JSON com a média, soma, maior valor de transação, menor valor de transação e contagem de quantas transações participam do cálculo.

###### Endpoint: [http://localhost:8080/statistics/](http://localhost:8080/statistics/)

###### response 200:
```json
{
  "sum": 509519,
  "min": 164,
  "max": 9983,
  "avg": 5095.19,
  "count": 100
}
```
## Executando a aplicação
------
Existem 2 formas simples para subir a aplicação, executando o jar pelo java `java -jar target/trabalho-final-0.0.1-SNAPSHOT.jar` ou executando o projeto pelo mvn `mvn spring-boot:run`. Ambas as formas devem ser executadas na raiz do projeto e sobem a aplicação na porta 8080 do localhost.


## Docker
------
O serviço está preparado para rodar com Docker, para ter 2 containers rodando simultaneamente basta seguir os passos:

### a.
Realizar o build da imagem com o comando:
`mvn install dockerfile:build`

### b.
Subir 1° instância apontando para a porta 8081 com o comando:
`docker run --name statistics-1 -d -p 8081:8080 springio/trabalho-final:latest`

### c.
Subir 2° instância apontando para uma porta diferente, como a 8082:
`docker run --name statistics-2 -d -p 8082:8080 springio/trabalho-final:latest`
