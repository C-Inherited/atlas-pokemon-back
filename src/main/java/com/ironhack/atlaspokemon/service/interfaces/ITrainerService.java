package com.ironhack.atlaspokemon.service.interfaces;

import com.ironhack.atlaspokemon.dto.CompleteTrainerDto;
import com.ironhack.atlaspokemon.dto.TrainerDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface ITrainerService {
    public List<TrainerDTO> getAllTrainers();

    public TrainerDTO getTrainerById(Integer id);

    public CompleteTrainerDto getCompleteTrainerById(Integer id);

    public TrainerDTO createTrainer(TrainerDTO trainerdto);

    public void deleteTrainer(Integer id);
}
