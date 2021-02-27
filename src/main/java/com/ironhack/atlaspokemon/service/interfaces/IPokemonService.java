package com.ironhack.atlaspokemon.service.interfaces;

import com.ironhack.atlaspokemon.dto.CompletePokemonDto;
import com.ironhack.atlaspokemon.dto.PokemonDto;

public interface IPokemonService {
    public PokemonDto addPokemon(CompletePokemonDto pokemonDto);

    public void deletePokemon(Integer id);
}
