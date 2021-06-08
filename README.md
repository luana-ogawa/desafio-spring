# desafio-spring
Desafio Spring Bootcamp

Para o projeto, foram feitas as seguintes considerações:
- Sellers e Buyers foram definidos como classes separadas
- IDs de usuários são gerados automaticamente, portanto o payload para o requisito US 0005 para criação de um novo post não necessita informação do id_post e nem do product_id, por exemplo:

{
    "userId": 2,
    "date": "07-06-2021",
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


- Já foram carregadas algumas informações que podem ser usadas para teste:

* "Vendedor Katia" - userId 1
* "Vendedor Alessandra" - userId 2
* "Vendedor Rodrigo" - userId 3

* "Usuario Vitoria" - userId 1 (Segue Katia e Alessandra)
* "Usuario Sandra" - userId 2 (Segue Katia e Alessandra)
* "Usuario Armando" - userId 3 (Segue Katia e Rodrigo)
    
* "Cadeira Gamer" (Post de Katia) ("03-06-2021")
* "Headset RGB" (Post de Katia) ("04-06-2021")
* "Mouse Optico" (Post de Katia) ("25-05-2021")
* "Teclado Mecanico" (Post de Alessandra) ("01-03-2019")
    
- Se a data atual passar de duas semanas da data de cadastro do produto, este não aparecerá no requisito US 0006
