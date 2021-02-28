package com.ironhack.atlaspokemon.service.impl;

import com.ironhack.atlaspokemon.dto.CompleteTrainerDto;
import com.ironhack.atlaspokemon.dto.PokemonDto;
import com.ironhack.atlaspokemon.dto.TrainerDTO;
import com.ironhack.atlaspokemon.models.Pokemon;
import com.ironhack.atlaspokemon.models.Trainer;
import com.ironhack.atlaspokemon.repository.PokemonRepository;
import com.ironhack.atlaspokemon.repository.TrainerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TrainerServiceTest {

    @MockBean
    TrainerRepository trainerRepository;

    @MockBean
    PokemonRepository pokemonRepository;

    @Autowired
    TrainerService trainerService;

    List<Trainer> trainers = new ArrayList<>();
    List<Pokemon> pokemones = new ArrayList<>();

    @BeforeEach
    void setUp() {
        trainers.addAll(List.of(
                new Trainer(1, "Paul", "eat haku ? <Optional>", 27, "image"),
                new Trainer(2, "Celia", "pasear haku", 27, "image")
        ));
    }

    @AfterEach
    void tearDown() {
        trainerRepository.deleteAll();
    }

    @Test
    void getAllTrainers() {
        when(trainerRepository.findAll()).thenReturn(trainers);

        List<TrainerDTO> trainersDTOList = trainerService.getAllTrainers();

        assertEquals(trainers.size(), trainersDTOList.size());
    }

    @Test
    void getAllTrainersWithPokemon() {
        when(trainerRepository.findAll()).thenReturn(trainers);
        when(pokemonRepository.findAll()).thenReturn(null);

        pokemones.addAll(List.of(
                new Pokemon(1, trainerRepository.getOne(1)),
                new Pokemon(23, trainerRepository.getOne(1)),
                new Pokemon(24, trainerRepository.getOne(2))
        ));

        trainers.get(0).setTeam(pokemones);
        List<PokemonDto> pokemonDtoList = pokemones.stream().map(Pokemon::toPokemonDto).collect(Collectors.toList());
        List<CompleteTrainerDto> completeTrainerDtos = trainerService.getAllTrainersWithPokemon();

        assertEquals(trainers.get(0).getTeam().size(), completeTrainerDtos.get(0).getTeam().size());

    }

    @Test
    void getTrainerById() {
    }

    @Test
    void getCompleteTrainerById() {
    }

    @Test
    void createTrainer() {
    }

    @Test
    void deleteTrainer() {
    }
}