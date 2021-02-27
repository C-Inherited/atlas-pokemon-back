package com.ironhack.atlaspokemon.service.impl;

import com.ironhack.atlaspokemon.dto.CompletePokemonDto;
import com.ironhack.atlaspokemon.dto.PokemonDto;
import com.ironhack.atlaspokemon.models.Pokemon;
import com.ironhack.atlaspokemon.models.Trainer;
import com.ironhack.atlaspokemon.repository.PokemonRepository;
import com.ironhack.atlaspokemon.repository.TrainerRepository;
import com.ironhack.atlaspokemon.service.interfaces.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PokemonService implements IPokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    public PokemonDto addPokemon(CompletePokemonDto pokemonDto) {
        Trainer trainer = trainerRepository.findById(pokemonDto.getTrainerId()).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trainer not found");
        });
        trainer.checkMaximumPokemon();
        return pokemonRepository.save(new Pokemon(pokemonDto.getPokemonId(), trainer)).toPokemonDto();
    }

    public void deletePokemon(Integer id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon not found");
        });
        pokemonRepository.delete(pokemon);
    }
}
