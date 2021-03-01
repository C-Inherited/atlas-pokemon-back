package com.ironhack.atlaspokemon.dto;

import com.ironhack.atlaspokemon.models.Trainer;


import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CompletePokemonDto {
    @NotNull
    private Integer pokemonId;
    @NotNull
    private Integer trainerId;

    public CompletePokemonDto() {
    }

    public CompletePokemonDto(@NotNull Integer pokemonId, @NotNull Integer trainerId) {
        this.pokemonId = pokemonId;
        this.trainerId = trainerId;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompletePokemonDto that = (CompletePokemonDto) o;
        return Objects.equals(pokemonId, that.pokemonId) && Objects.equals(trainerId, that.trainerId);
    }

}
