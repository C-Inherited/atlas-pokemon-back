create table trainer
(
    id SERIAL PRIMARY KEY
        primary key,
    age int null,
    hobby varchar(255) null,
    image_url varchar(255) null,
    name varchar(255) null
);

create table pokemon
(
    id SERIAL PRIMARY KEY
        primary key,
    pokemon_id int null,
    trainer_id int null,
    constraint FKqv1tudyd69fjhvv9m1eij01hu
        foreign key (trainer_id) references trainer (id)
);


INSERT INTO atlas_pokemon.trainer (id, age, hobby, image_url, name) VALUES (1, 18, 'jugar futbol', 'https://www.seekpng.com/png/detail/242-2421423_pokemon-trainer-sprite-png-pixel-pokemon-trainer-sprites.png', 'Nerea');
INSERT INTO atlas_pokemon.trainer (id, age, hobby, image_url, name) VALUES (2, 28, 'jugar tenis', 'https://www.seekpng.com/png/detail/242-2421423_pokemon-trainer-sprite-png-pixel-pokemon-trainer-sprites.png', 'Salvatore');
INSERT INTO atlas_pokemon.trainer (id, age, hobby, image_url, name) VALUES (3, 28, 'jugar tenis', 'https://www.seekpng.com/png/detail/242-2421423_pokemon-trainer-sprite-png-pixel-pokemon-trainer-sprites.png', 'Salvatore');
INSERT INTO atlas_pokemon.trainer (id, age, hobby, image_url, name) VALUES (4, 25, 'jugar painball', 'https://www.seekpng.com/png/detail/242-2421423_pokemon-trainer-sprite-png-pixel-pokemon-trainer-sprites.png', 'Celia');
INSERT INTO atlas_pokemon.trainer (id, age, hobby, image_url, name) VALUES (5, 31, 'jugar futbol', 'https://www.seekpng.com/png/detail/242-2421423_pokemon-trainer-sprite-png-pixel-pokemon-trainer-sprites.png', 'Paul');

INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (1, 1, 1);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (2, 2, 1);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (3, 3, 1);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (4, 4, 1);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (5, 5, 1);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (6, 6, 1);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (8, 8, 1);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (9, 8, 2);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (10, 8, 2);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (11, 10, 2);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (12, 15, 3);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (13, 15, 3);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (14, 19, 4);
INSERT INTO atlas_pokemon.pokemon (id, pokemon_id, trainer_id) VALUES (15, 19, 4);
