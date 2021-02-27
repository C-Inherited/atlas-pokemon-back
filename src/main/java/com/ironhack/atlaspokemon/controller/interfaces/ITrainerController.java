package com.ironhack.atlaspokemon.controller.interfaces;

import com.ironhack.atlaspokemon.dto.CompleteTrainerDto;
import com.ironhack.atlaspokemon.dto.TrainerDTO;
import java.util.List;

public interface ITrainerController {

    public List<TrainerDTO> getAllTrainers();
    public TrainerDTO getTrainer(Integer id);
    public CompleteTrainerDto getTrainerWithPokemon(Integer id);
    public TrainerDTO createTrainer(TrainerDTO trainerdto);
    public void createTrainer(Integer id);
}
