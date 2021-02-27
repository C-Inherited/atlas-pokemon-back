package com.ironhack.atlaspokemon.controller.interfaces;

import com.ironhack.atlaspokemon.dto.CompletePokemonDto;
import com.ironhack.atlaspokemon.dto.PokemonDto;

public interface IPokemonController {
    public PokemonDto addPokemon(CompletePokemonDto pokemonDto);

    public void deletePokemon(Integer id);
}
