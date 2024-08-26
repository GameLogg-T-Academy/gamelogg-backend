# GameLogg API

Endpoints:
```shell
GET /games/{id}
```
Retorna jogo de acordo com ID

---

```shell
PUT /games/{id}
```
Atualiza jogo

---

```shell
DELETE /games/{id}
```
Remove jogo

---

```shell
GET /games
```
Retorna lista de jogos

Parâmetros opcionais:

- pageNumber - integer
- pageSize -  integer
- title - string
- status - string
- maxPrice - number
- favorite - boolean
- developer - string
- publisher - string
- releaseYear - integer
- genre - string

---

```shell
POST /games
```
Adiciona novo jogo

---

Para testar e ver mais detalhes dos endpoints, execute a aplicação e acesse a URL http://localhost:8080/swagger-ui/index.html