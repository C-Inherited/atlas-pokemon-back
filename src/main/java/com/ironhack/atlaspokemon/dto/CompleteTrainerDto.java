package com.ironhack.atlaspokemon.dto;

import com.ironhack.atlaspokemon.models.Pokemon;

import java.util.List;
import java.util.Objects;

public class CompleteTrainerDto {

    private Integer id;
    private String name;
    private String hobby;
    private Integer age;
    private String imageUrl;
    private List<PokemonDto> team;

    public CompleteTrainerDto() {
    }

    public CompleteTrainerDto(Integer id, String name, String hobby, Integer age, String imageUrl, List<PokemonDto> team) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
        this.age = age;
        this.imageUrl = imageUrl;
        this.team = team;
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

    public List<PokemonDto> getTeam() {
        return team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompleteTrainerDto that = (CompleteTrainerDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(hobby, that.hobby) && Objects.equals(age, that.age) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(team, that.team);
    }

}
