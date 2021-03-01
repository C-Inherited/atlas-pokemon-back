package com.ironhack.atlaspokemon.service.impl;

import com.ironhack.atlaspokemon.dto.CompletePokemonDto;
import com.ironhack.atlaspokemon.dto.PokemonDto;

import com.ironhack.atlaspokemon.models.Trainer;
import com.ironhack.atlaspokemon.repository.PokemonRepository;
import com.ironhack.atlaspokemon.repository.TrainerRepository;
import com.ironhack.atlaspokemon.models.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PokemonServiceTest {

    @MockBean
    private PokemonRepository pokemonRepository;
    @MockBean
    private TrainerRepository trainerRepository;

    @Autowired
    private PokemonService pokemonService;

    private Trainer trainer;
    private CompletePokemonDto completePokemonDto;
    private PokemonDto pokemonDto;
    private Pokemon pokemon;

    @BeforeEach
    void setUp() {
        trainer = new Trainer(1,"nerea","leer",27,"image");

        completePokemonDto = new CompletePokemonDto(1,1);
        pokemonDto = new PokemonDto(1,1);
        pokemon = new Pokemon(1, 1,trainer);
        pokemon.setId(1);
    }


    @Test
    void addPokemon() {
        when(trainerRepository.findById(trainer.getId())).thenReturn(Optional.ofNullable((trainer)));
        when(pokemonRepository.save(new Pokemon(1,trainer))).thenReturn(pokemon);

        PokemonDto pokemonDtoResponse = pokemonService.addPokemon(completePokemonDto);

        assertEquals(pokemonDto,pokemonDtoResponse);
    }

    @Test
    void addPokemon_noTrainer_Exception() {
        when(trainerRepository.findById(trainer.getId())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, ()-> pokemonService.addPokemon(completePokemonDto));

    }

    @Test
    void deletePokemon() {
        when(pokemonRepository.findById(pokemon.getId())).thenReturn(Optional.of(pokemon));

        pokemonService.deletePokemon(pokemon.getId());

        verify(pokemonRepository).delete(pokemon);
    }


    @Test
    void deletePokemon_throw_NoPokemonException() {
        when(pokemonRepository.findById(pokemon.getId())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> pokemonService.deletePokemon(pokemon.getId()));
    }
}
