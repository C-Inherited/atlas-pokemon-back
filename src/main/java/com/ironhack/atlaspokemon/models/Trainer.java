package com.ironhack.atlaspokemon.models;

import com.ironhack.atlaspokemon.dto.CompleteTrainerDto;
import com.ironhack.atlaspokemon.dto.PokemonDto;
import com.ironhack.atlaspokemon.dto.TrainerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String hobby;
    private Integer age;
    private String imageUrl;

// se borran en cascada los pokemon y despues el trainer

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pokemon> team;

    public Trainer() {
    }

    public Trainer(Integer id, String name, String hobby, Integer age, String imageUrl) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
        this.age = age;
        this.imageUrl = imageUrl;
        this.team = new ArrayList<>();
    }

    public TrainerDTO toTrainerDto() {
        return new TrainerDTO(this.getId(), this.getName(), this.getHobby(), this.getAge(), this.getImageUrl());
    }

    public CompleteTrainerDto toCompleteTrainerDto() {
        return new CompleteTrainerDto(this.getId(), this.getName(), this.getHobby(), this.getAge(),
                this.getImageUrl(),this.team.stream().map(pokemon -> new PokemonDto(pokemon.getId(), pokemon.getPokemonId())).collect(Collectors.toList()));
    }

    public void checkMaximumPokemon() {
        if (team.size() >= 7)
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "The trainer team its completed!!");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public Integer getAge() {
        return age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id) && Objects.equals(name, trainer.name) && Objects.equals(hobby, trainer.hobby) && Objects.equals(age, trainer.age) && Objects.equals(imageUrl, trainer.imageUrl) && Objects.equals(team, trainer.team);
    }

}
