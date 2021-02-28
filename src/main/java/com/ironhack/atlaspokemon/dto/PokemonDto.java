package com.ironhack.atlaspokemon.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonDto that = (PokemonDto) o;
        return Objects.equals(id, that.id) && Objects.equals(pokemonId, that.pokemonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pokemonId);
    }
}
