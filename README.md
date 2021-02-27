
# Atlas Pokemon API BACKEND

The proyect have swagger, when you turn on the server you can see all endpoints in this URL:

http://localhost:8080/swagger-ui.html#

## List of our endpoints that u need to know 

- Trainer Endpoints

| PETITION | ROUTE | DESCRIPTION | RESPONSE CODES  
| ------------- | ------------- | ------------- | ------------- |
|GET | /trainers | Retrieve all trainers details without their pokemon team | 
|GET | /trainer/{id}/pokemon | Retrieve a trainer by id without their pokemon team | 404 Not found if trainer not present
|GET | /trainer/{id}/pokemon | Retrieve a trainer by id with their pokemon team | 404 Not found if trainer not present
|POST | /trainer | Create a trainer | 
|DELETE | /trainer/{id}  | Delete a trainer by id | 404 Not found if trainer not present

- Pokemon Endpoints

| PETITION | ROUTE | DESCRIPTION | RESPONSE CODES
| ------------- | ------------- | ------------- | ------------- |
|POST | /pokemon | Add a pokemon to a trainer team | 404 Not found if trainer not present OR 412 Precondition Failed if trainer have 7 or more pokemon in their team
|DELETE | /pokemon/{id} | Delete pokemon by id from a team | 404 Not found if pokemon not present


## Examples

CREATE A TRAINER

POST /trainer/
Request 
```
{
  "age": 31,
  "hobby": "jugar futbol",
  "imageUrl": "https://www.seekpng.com/png/detail/242-2421423_pokemon-trainer-sprite-png-pixel-pokemon-trainer-sprites.png",
  "name": "Paul"
}
```
Response
```
{
  "id": 5,
  "name": "Paul",
  "hobby": "jugar futbol",
  "age": 31,
  "imageUrl": "https://www.seekpng.com/png/detail/242-2421423_pokemon-trainer-sprite-png-pixel-pokemon-trainer-sprites.png"
}
```

GET /trainer/1/pokemon
Response
```
{
  "id": 1,
  "name": "Nerea",
  "hobby": "jugar futbol",
  "age": 18,
  "imageUrl": "https://www.seekpng.com/png/detail/242-2421423_pokemon-trainer-sprite-png-pixel-pokemon-trainer-sprites.png",
  "team": [
    {
      "id": 1,
      "pokemonId": 1
    },
    {
      "id": 2,
      "pokemonId": 2
    },
    {
      "id": 3,
      "pokemonId": 3
    },
    {
      "id": 4,
      "pokemonId": 4
    },
    {
      "id": 5,
      "pokemonId": 5
    },
    {
      "id": 6,
      "pokemonId": 6
    },
    {
      "id": 8,
      "pokemonId": 8
    }
  ]
}
```

POST /pokemon/
REQUEST
```
{
"pokemonId": 19,
"trainerId": 4
}
```
RESPONSE
```
{
"id": 15,
"pokemonId": 19
}```
