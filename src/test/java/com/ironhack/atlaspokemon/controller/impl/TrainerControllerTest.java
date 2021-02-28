package com.ironhack.atlaspokemon.controller.impl;

import com.ironhack.atlaspokemon.dto.TrainerDTO;
import com.ironhack.atlaspokemon.models.Pokemon;
import com.ironhack.atlaspokemon.models.Trainer;
import com.ironhack.atlaspokemon.repository.PokemonRepository;
import com.ironhack.atlaspokemon.repository.TrainerRepository;
import com.ironhack.atlaspokemon.service.impl.TrainerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrainerControllerTest {


    public Trainer trainer;
    @Autowired
    public TrainerRepository trainerRepository;

    @Autowired
    public PokemonRepository pokemonRepository;
    @Autowired
    public TrainerService trainerService;

    public List<Pokemon> pokemons = new ArrayList<>();

    @BeforeEach
    void setUp() {
         trainer = new Trainer(1,"Paul","x",27,"image");
        Pokemon pokemon = new Pokemon(1, trainer);
        Pokemon pokemon2 = new Pokemon(2, trainer);
        pokemons.add(pokemon);
        pokemons.add(pokemon2);
        trainer.setTeam(pokemons);

        trainerRepository.save(trainer);
        pokemonRepository.saveAll(pokemons);
    }

    @Test
    void getTrainerById(){
        TrainerDTO trainerDTO = trainer.toTrainerDto();
        assertEquals(trainerService.getTrainerById(1), trainerDTO);
    }


}
