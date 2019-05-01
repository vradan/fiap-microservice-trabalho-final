# Payment Service
  Este serviço REST foi construído com spring-boot e tem como objetivo servir com uma API de estatística. Os métodos implementados são POST para salvar uma transação e GET para retornar uma estatística das transações dos últimos 60 segundos.
  
Obs.: Para rodar o projeto, executar na raiz do projeto o comando `mvn sprint-boot:run`

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
