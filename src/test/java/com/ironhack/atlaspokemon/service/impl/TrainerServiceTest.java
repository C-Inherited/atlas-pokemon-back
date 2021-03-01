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
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
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
    private Trainer trainer;
    private CompleteTrainerDto completeTrainerDto;
    private TrainerDTO trainerDto;

    @BeforeEach
    void setUp() {
        trainer = new Trainer(1,"nerea","leer",27,"image");
        completeTrainerDto = new CompleteTrainerDto(1,"nerea","leer", 27, "image", List.of());
       trainerDto = new TrainerDTO(1,"nerea","leer",27,"image");
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
    void getTrainerById_correct() {
        when(trainerRepository.findById(trainer.getId())).thenReturn(Optional.ofNullable(trainer));

        TrainerDTO trainerDTOResponse = trainerService.getTrainerById(trainer.getId());

        assertEquals(trainerDto, trainerDTOResponse);
    }

    @Test
    void getTrainerById_exception() {
        when(trainerRepository.findById(trainer.getId())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, ()-> trainerService.getTrainerById(trainer.getId()));
    }


    @Test
    void getCompleteTrainerById() {
        when(trainerRepository.findById(trainer.getId())).thenReturn(Optional.ofNullable(trainer));

        CompleteTrainerDto completeTrainerDtoResponse = trainerService.getCompleteTrainerById(trainer.getId());

        assertEquals(completeTrainerDto,completeTrainerDtoResponse);
    }

    @Test
    void getCompleteTrainerById_Exception() {
        when(trainerRepository.findById(trainer.getId())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, ()-> trainerService.getCompleteTrainerById(trainer.getId()));

    }

    @Test
    void createTrainer() {
        when(trainerRepository.save(trainer)).thenReturn(trainer);

        TrainerDTO trainerDTOResponse = trainerService.createTrainer(trainer.toTrainerDto());

        assertEquals(trainerDto, trainerDTOResponse);
    }

    @Test
    void deleteTrainer() {
     when(trainerRepository.findById(trainer.getId())).thenReturn(Optional.ofNullable(trainer));

       trainerService.deleteTrainer(trainer.getId());

       verify(trainerRepository).deleteById(trainer.getId());
    }

    @Test
    void deleteTrainer_Exception() {
        when(trainerRepository.findById(trainer.getId())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, ()-> trainerService.deleteTrainer(trainer.getId()));
    }

}
