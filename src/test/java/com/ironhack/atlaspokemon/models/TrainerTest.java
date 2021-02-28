package com.ironhack.atlaspokemon.models;

import com.ironhack.atlaspokemon.dto.CompleteTrainerDto;
import com.ironhack.atlaspokemon.dto.TrainerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    void toTrainerDto_Correct() {
        Trainer trainer= new Trainer(1, "nerea","cantar",27,"image");
        TrainerDTO trainerDtoExpected = new TrainerDTO(1,"nerea","cantar",27,"image");

        TrainerDTO trainerDTO = trainer.toTrainerDto();

        assertEquals(trainerDtoExpected,trainerDTO);
    }

    @Test
    void toCompleteTrainerDto_Correct() {
        Trainer trainer= new Trainer(1, "nerea","cantar",27,"image");
        CompleteTrainerDto completeTrainerDtoExpected = new CompleteTrainerDto(1,"nerea","cantar",27,"image", List.of());

        CompleteTrainerDto completeTrainerDto = trainer.toCompleteTrainerDto();

        assertEquals(completeTrainerDtoExpected,completeTrainerDto);
    }

    @Test
    void checkMaximumPokemon_Exception() {
        Trainer trainer= new Trainer(1, "nerea","cantar",27,"image");
        Pokemon pokemon = new Pokemon(1,trainer);
        Pokemon pokemon2 = new Pokemon(2,trainer);
        Pokemon pokemon3 = new Pokemon(3,trainer);
        Pokemon pokemon4 = new Pokemon(4,trainer);
        Pokemon pokemon5 = new Pokemon(5,trainer);
        Pokemon pokemon6 = new Pokemon(6,trainer);
        Pokemon pokemon7 = new Pokemon(7,trainer);
        trainer.setTeam(List.of(pokemon,pokemon2,pokemon3,pokemon4,pokemon5,pokemon6,pokemon7));

        assertThrows(ResponseStatusException.class, ()-> {
            trainer.checkMaximumPokemon();
        });
    }
    @Test
    void checkMaximumPokemon_NoException() {
        Trainer trainer= new Trainer(1, "nerea","cantar",27,"image");
        Pokemon pokemon = new Pokemon(1,trainer);
        Pokemon pokemon2 = new Pokemon(2,trainer);
        Pokemon pokemon3 = new Pokemon(3,trainer);
        Pokemon pokemon4 = new Pokemon(4,trainer);
        Pokemon pokemon5 = new Pokemon(5,trainer);

        trainer.setTeam(List.of(pokemon,pokemon2,pokemon3,pokemon4,pokemon5));

        trainer.checkMaximumPokemon();
    }

}
