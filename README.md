# 💰 Desafio Itaú — API de Transações e Estatísticas

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen?logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-build-blue?logo=apachemaven&logoColor=white)

API REST desenvolvida em **Java 21 + Spring Boot** para o desafio de backend
do Itaú. A aplicação recebe transações financeiras e calcula estatísticas
(quantidade, soma, média, mínimo e máximo) sobre as transações ocorridas nos
últimos 60 segundos — tudo **armazenado em memória**, sem banco de dados.

> 📋 Desafio original: [feltex/desafio-itau-backend](https://github.com/feltex/desafio-itau-backend)
---

## 🛠 Tecnologias

- **Java 21**
- **Spring Boot 4** (Web MVC, Validation)
- **Maven**
- **Postman** para testes

---

## 🔌 Endpoints da API

### `POST /transacao`

Registra uma nova transação.

**Request**
```json
{
  "valor": 123.45,
  "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

**Respostas**

| Status | Situação |
| --- | --- |
| `201 Created` | Transação válida e registrada (sem corpo) |
| `422 Unprocessable Entity` | Campo ausente, `valor` negativo ou `dataHora` no futuro (sem corpo) |
| `400 Bad Request` | JSON malformado / requisição ilegível (sem corpo) |

---

### `DELETE /transacao`

Remove todas as transações armazenadas em memória.

| Status | Situação |
| --- | --- |
| `200 OK` | Dados apagados com sucesso (sem corpo) |

---

### `GET /estatistica`

Retorna as estatísticas das transações ocorridas no tempo
de 60 segundos.

**Response — `200 OK`**
```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

> Se não houver transações em 60 segundos, **todos** os campos retornam `0`.

```bash
curl -i http://localhost:8080/estatistica
```

---

## ✅ Regras de negócio

Uma transação só é aceita se, simultaneamente:

1. Os campos `valor` e `dataHora` estiverem preenchidos;
2. `dataHora` não estiver no futuro;
3. `valor` for maior ou igual a `0`.

Qualquer uma dessas regras violadas resulta em `422 Unprocessable Entity`.
Um JSON que a API não consegue nem interpretar (sintaxe inválida) resulta em
`400 Bad Request`.

---

## 📂 Estrutura do projeto

```
src/main/java/.../desafioItau
├── controller/       # Endpoints REST (TransacaoController, EstatisticaController)
├── dto/               # Objetos de entrada/saída da API
├── exception/         # Tratamento global de erros (@RestControllerAdvice)
├── model/             # Modelo de domínio armazenado em memória
└── service/           # Regras de negócio e armazenamento
```

---

## 💡 Decisões técnicas

- **Armazenamento em memória** com `ConcurrentLinkedDeque`, seguro para
  acesso concorrente sem sincronização manual.
- A cada leitura de `GET /estatistica`, transações fora da janela de tempo
  são removidas da estrutura em memória, evitando crescimento indefinido de
  uso de memória.
- Validação de entrada com Bean Validation (`@NotNull`, `@DecimalMin`,
  `@PastOrPresent`); um `@RestControllerAdvice` global garante que falhas de
  regra de negócio retornem `422` e erros de parsing retornem `400`, sempre
  sem corpo na resposta — conforme exigido pela especificação do desafio.]
---

## 👤 Autor

Desenvolvido por João Gabriel como parte do desafio de backend do Itaú.
