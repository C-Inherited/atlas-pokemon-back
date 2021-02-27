package com.ironhack.atlaspokemon.controller.impl;

import com.ironhack.atlaspokemon.controller.interfaces.IPokemonController;
import com.ironhack.atlaspokemon.dto.CompletePokemonDto;
import com.ironhack.atlaspokemon.dto.PokemonDto;
import com.ironhack.atlaspokemon.service.impl.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PokemonController implements IPokemonController {


    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/pokemon")
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonDto addPokemon(@RequestBody @Valid CompletePokemonDto pokemonDto) {
        return pokemonService.addPokemon(pokemonDto);
    }

    @PostMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePokemon(@PathVariable(name = "id") Integer id) {
        pokemonService.deletePokemon(id);
    }
}
