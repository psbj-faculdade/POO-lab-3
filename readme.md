# API de Gerenciamento de Produtos

### ALUNOS:
Paulo Sergio Barbosa Junior - RA: 202111362

Esta é uma API de gerenciamento de produtos implementada em Java com o framework Spring Boot. Ela permite criar, listar, buscar, atualizar e excluir produtos. A implementação é para fins de teste e não requer um banco de dados, usando armazenamento em memória para persistência.

## Rotas

### 1. Criar um Produto

**Endpoint:** `POST /products`
**Status Code:** `201`

Cria um novo produto com os seguintes campos no corpo da requisição:

- `name` (String): Nome do produto.
- `price` (Double): Preço do produto.

Exemplo de corpo da requisição:

```json
{
    "name": "Produto A",
    "price": 19.99
}
```

Exemplo de corpo da resposta:

```json
{
    "id": 1,
    "name": "Produto A",
    "price": 19.99
}
```

### 2. Listar Todos os Produtos

Esta rota permite listar todos os produtos cadastrados na API.

**Endpoint:** `GET /products`
**Status Code:** `200`

#### Exemplo de Response

```json
[
    {
        "id": 1,
        "name": "Produto A",
        "price": 19.99
    }
]
```

### 3. Busca produto por id

Esta rota permite buscar um produto especifico cadastrado na API.

**Endpoint:** `GET /product/{id}`
**Status Code:** `200`

#### Exemplo de Response

```json
{
    "id": 1,
    "name": "Produto A",
    "price": 19.99
}
```

### 4. Atualizar produto por id

Esta rota permite atualizar um produto especifico cadastrado na API.

**Endpoint:** `PUT /product`
**Status Code:** `200`

#### Exemplo de Requisição

```json
{
    "id": 1,
    "name": "Produto A",
    "price": 19.99
}
```

#### Exemplo de Response

```json
{
    "id": 1,
    "name": "Produto A",
    "price": 19.99
}
```

### 5. Delete produto por id

Esta rota permite deletar um produto especifico cadastrado na API.

**Endpoint:** `Delete /product/{id}`
**Status Code:** `204`

#### Exemplo de Response

```json
```


### Link documentação POSTMAN

https://documenter.getpostman.com/view/26353942/2s9YXiaN16