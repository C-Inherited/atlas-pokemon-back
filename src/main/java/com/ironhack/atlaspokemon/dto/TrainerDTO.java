package com.ironhack.atlaspokemon.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TrainerDTO {

    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String hobby;
    @NotNull
    @Min(value = 15, message = "the age can not be less than 15")
    @Max(value = 80, message = "the age can not be grater than 80")
    private Integer age;
    @NotEmpty
    private String imageUrl;

    public TrainerDTO() {
    }

    public TrainerDTO(Integer id, @NotEmpty String name, @NotEmpty String hobby, @NotNull @Min(value = 15, message = "the age can not be less than 15") @Max(value = 80, message = "the age can not be grater than 80") Integer age, @NotEmpty String imageUrl) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
        this.age = age;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainerDTO that = (TrainerDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(hobby, that.hobby) && Objects.equals(age, that.age) && Objects.equals(imageUrl, that.imageUrl);
    }

}
