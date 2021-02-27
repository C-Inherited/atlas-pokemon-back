package com.ironhack.atlaspokemon.controller.impl;

import com.ironhack.atlaspokemon.controller.interfaces.ITrainerController;
import com.ironhack.atlaspokemon.dto.CompleteTrainerDto;
import com.ironhack.atlaspokemon.dto.TrainerDTO;
import com.ironhack.atlaspokemon.service.impl.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerController implements ITrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/trainers")
    @ResponseStatus(HttpStatus.OK)
    public List<TrainerDTO> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @GetMapping("/trainers/pokemon")
    @ResponseStatus(HttpStatus.OK)
    public List<CompleteTrainerDto> getAllTrainersWithPokemon() {
        return trainerService.getAllTrainersWithPokemon();
    }

    @GetMapping("/trainer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainerDTO getTrainer(@PathVariable(name = "id") Integer id) {
        return trainerService.getTrainerById(id);
    }

    @GetMapping("/trainer/{id}/pokemon")
    @ResponseStatus(HttpStatus.OK)
    public CompleteTrainerDto getTrainerWithPokemon(@PathVariable(name = "id") Integer id) {
        return trainerService.getCompleteTrainerById(id);
    }

    @PostMapping("/trainer")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerDTO createTrainer(@RequestBody @Valid TrainerDTO trainerdto) {
        return trainerService.createTrainer(trainerdto);
    }

    @DeleteMapping("/trainer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void createTrainer(@PathVariable(name = "id") Integer id) {
        trainerService.deleteTrainer(id);
    }
}
