package com.ironhack.atlaspokemon.repository;

import com.ironhack.atlaspokemon.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {

}
