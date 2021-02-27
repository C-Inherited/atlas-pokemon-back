package com.ironhack.atlaspokemon.dto;

public class PokemonDto {

    private Integer id;
    private Integer pokemonId;

    public PokemonDto() {
    }

    public PokemonDto(Integer id, Integer pokemonId) {
        this.id = id;
        this.pokemonId = pokemonId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }
}
