package com.ironhack.atlaspokemon.models;

import com.ironhack.atlaspokemon.dto.PokemonDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PokemonTest {

    @Test
    void toPokemonDto() {
        Trainer trainer= new Trainer(1, "nerea","cantar",27,"image");
        Pokemon pokemon = new Pokemon(1,trainer);
        pokemon.setId(1);
        PokemonDto pokemonDtoExpected = new PokemonDto(1,1);

        PokemonDto pokemonDto = pokemon.toPokemonDto();

        assertEquals(pokemonDtoExpected,pokemonDto);
    }
}
