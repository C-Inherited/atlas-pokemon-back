package com.ironhack.atlaspokemon.service.impl;

import com.ironhack.atlaspokemon.dto.CompleteTrainerDto;
import com.ironhack.atlaspokemon.dto.TrainerDTO;
import com.ironhack.atlaspokemon.models.Trainer;
import com.ironhack.atlaspokemon.repository.TrainerRepository;
import com.ironhack.atlaspokemon.service.interfaces.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService implements ITrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public List<TrainerDTO> getAllTrainers() {
        return trainerRepository.findAll().stream().map(Trainer::toTrainerDto).collect(Collectors.toList());
    }

    public List<CompleteTrainerDto> getAllTrainersWithPokemon() {
        return trainerRepository.findAll().stream().map(Trainer::toCompleteTrainerDto).collect(Collectors.toList());
    }

    public TrainerDTO getTrainerById(Integer id) {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trainer not found");
        });
        return trainer.toTrainerDto();
    }

    public CompleteTrainerDto getCompleteTrainerById(Integer id) {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trainer not found");
        });
        return trainer.toCompleteTrainerDto();
    }

    public TrainerDTO createTrainer(TrainerDTO trainerdto) {
        return trainerRepository.save(new Trainer(trainerdto.getId(), trainerdto.getName(), trainerdto.getHobby(), trainerdto.getAge(), trainerdto.getImageUrl())).toTrainerDto();
    }

    public void deleteTrainer(Integer id) {
        trainerRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trainer not found");
        });
        trainerRepository.deleteById(id);
    }

}
