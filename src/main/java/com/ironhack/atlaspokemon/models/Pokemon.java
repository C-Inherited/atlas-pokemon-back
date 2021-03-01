package com.ironhack.atlaspokemon.models;

import com.ironhack.atlaspokemon.dto.PokemonDto;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer pokemonId;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public Pokemon() {
    }

    public Pokemon(Integer id, Integer pokemonId, Trainer trainer) {
        this.id = id;
        this.pokemonId = pokemonId;
        this.trainer = trainer;
    }

    public Pokemon(Integer pokemonId, Trainer trainer) {
        this.pokemonId = pokemonId;
        this.trainer = trainer;
    }

    public PokemonDto toPokemonDto(){
        return new PokemonDto(this.id,this.pokemonId);
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

    public Trainer getTrainer() {
        return trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id) && Objects.equals(pokemonId, pokemon.pokemonId) && Objects.equals(trainer, pokemon.trainer);
    }
}
