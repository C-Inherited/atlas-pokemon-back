package com.ironhack.atlaspokemon.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.atlaspokemon.dto.CompleteTrainerDto;
import com.ironhack.atlaspokemon.dto.PokemonDto;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class TrainerControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public TrainerDTO trainer;

    @MockBean
    public TrainerService trainerService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        trainer = new TrainerDTO(1, "Paul", "x", 27, "image");

    }

    @Test
    void getTrainers() throws Exception {
        String expectedJson = "[{\"id\":1,\"name\":\"Paul\",\"hobby\":\"x\",\"age\":27,\"imageUrl\":\"image\"}]";
        when(trainerService.getAllTrainers()).thenReturn(List.of(trainer));
        MvcResult result = mockMvc
                .perform(get("/trainers"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    void getTrainersPokemon() throws Exception {
        String expectedJson = "[{\"id\":1,\"name\":\"Paul\",\"hobby\":\"x\",\"age\":27,\"imageUrl\":\"image\",\"team\":[{\"id\":1,\"pokemonId\":1}]}]";
        CompleteTrainerDto trainerWithPokemon = new CompleteTrainerDto(1, "Paul", "x", 27, "image", List.of(new PokemonDto(1, 1)));
        when(trainerService.getAllTrainersWithPokemon()).thenReturn(List.of(trainerWithPokemon));

        MvcResult result = mockMvc
                .perform(get("/trainers/pokemon"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    void getTrainerWithPokemon() throws Exception {
        String expectedJson = "{\"id\":1,\"name\":\"Paul\",\"hobby\":\"x\",\"age\":27,\"imageUrl\":\"image\",\"team\":[{\"id\":1,\"pokemonId\":1}]}";
        CompleteTrainerDto trainerWithPokemon = new CompleteTrainerDto(1, "Paul", "x", 27, "image", List.of(new PokemonDto(1, 1)));
        when(trainerService.getCompleteTrainerById(1)).thenReturn(trainerWithPokemon);

        MvcResult result = mockMvc
                .perform(get("/trainer/1/pokemon"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    void getTrainersById() throws Exception {
        String expectedJson = "{\"id\":1,\"name\":\"Paul\",\"hobby\":\"x\",\"age\":27,\"imageUrl\":\"image\"}";
        when(trainerService.getTrainerById(1)).thenReturn(trainer);

        MvcResult result = mockMvc
                .perform(get("/trainer/1"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    void createTrainer() throws Exception {
        when(trainerService.createTrainer(trainer)).thenReturn(trainer);

        String body = objectMapper.writeValueAsString(trainer);
        MvcResult result =  mockMvc
                .perform(post("/trainer")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertEquals("{\"id\":1,\"name\":\"Paul\",\"hobby\":\"x\",\"age\":27,\"imageUrl\":\"image\"}", result.getResponse().getContentAsString());

    }

    @Test
    void deleteTrainerById() throws Exception {
        MvcResult result = mockMvc
                .perform(delete("/trainer/1"))
                .andExpect(status().isOk())
                .andReturn();

        verify(trainerService).deleteTrainer(1);
    }

}
