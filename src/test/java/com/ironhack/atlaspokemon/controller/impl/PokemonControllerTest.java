package com.ironhack.atlaspokemon.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.atlaspokemon.dto.CompletePokemonDto;
import com.ironhack.atlaspokemon.dto.PokemonDto;
import com.ironhack.atlaspokemon.dto.TrainerDTO;
import com.ironhack.atlaspokemon.service.impl.PokemonService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PokemonControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CompletePokemonDto pokemon;

    @MockBean
    public PokemonService pokemonService;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        pokemon = new CompletePokemonDto(1, 1);

    }

    @Test
    void addPokemon() throws Exception {
        when(pokemonService.addPokemon(pokemon)).thenReturn(new PokemonDto(1,1));

        String body = objectMapper.writeValueAsString(pokemon);
        MvcResult result =  mockMvc
                .perform(post("/pokemon")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertEquals("{\"id\":1,\"pokemonId\":1}", result.getResponse().getContentAsString());
    }

    @Test
    void deletePokemonById() throws Exception {
        MvcResult result = mockMvc
                .perform(delete("/pokemon/1"))
                .andExpect(status().isOk())
                .andReturn();

        verify(pokemonService).deletePokemon(1);
    }

}
