# desafio-spring
## Desafio Spring Bootcamp

### Para o projeto, foram feitas as seguintes considerações:
1. Sellers e Buyers foram definidos como classes separadas, logo um Seller pode ter o mesmo userId de um Buyer
2. IDs de usuários são gerados automaticamente, portanto o payload para os requisitos US 0005 e US 0010 para criação de um novo post e post promocional não necessitam informação do id_post e nem do product_id, por exemplo:

#### US 0005

```
{
    "userId": 2,
    "date": "08-06-2021",
    "category": "CADEIRAS",
    "price": 900.0,
    "detail": {
        "productName": "CADEIRA GAMER",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Couro"
    }
}
```

#### US 0010
```
{
    "userId": 3,
    "date": "08-06-2021",
    "category": "CADEIRAS",
    "price": 900.0,
    "detail": {
        "productName": "CADEIRA GAMER",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Green & Black",
        "notes": "Couro"
    },
    "hasPromo": true,
    "discount": 0.25
}
```


3. Já foram carregadas algumas informações que podem ser usadas para teste:

#### Vendedores

```
    "Vendedor Katia" - userId 1
    "Vendedor Alessandra" - userId 2
    "Vendedor Rodrigo" - userId 3
```

#### Compradores

```
    "Comprador Vitoria" - userId 1 (Segue Katia e Alessandra)
    "Comprador Sandra" - userId 2 (Segue Katia e Alessandra)
    "Comprador Armando" - userId 3 (Segue Katia e Rodrigo)
```

#### Posts
```
    "Cadeira Gamer" (Post de Katia) ("03-06-2021")
    "Headset RGB" (Post de Katia) ("04-06-2021")
    "Mouse Optico" (Post de Katia) ("25-05-2021")
    "Teclado Mecanico" (Post de Alessandra) ("01-03-2019")
    "Cadeira Escritorio"(Post de Rodrigo) ("08-06-2021") - item promocional
```  


4. Se a data atual passar de duas semanas da data de cadastro do produto, este não aparecerá no requisito US 0006
