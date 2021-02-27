package com.ironhack.atlaspokemon.models;


import com.ironhack.atlaspokemon.dto.CompletePokemonDto;
import com.ironhack.atlaspokemon.dto.PokemonDto;

import javax.persistence.*;

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

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

}
