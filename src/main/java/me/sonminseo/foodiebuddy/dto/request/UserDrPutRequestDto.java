package me.sonminseo.foodiebuddy.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserDrPutRequestDto {
    private Long userId;

    private String religion;
    private String vegetarian;

    private String meat;
    private Boolean egg;
    private String dairy;
    private String seafood;
    private String nut;
    private Boolean gluten;
    private String fruit;
    private String vegetable;
    private String other;


    @Builder
    public UserDrPutRequestDto(String religion, String vegetarian,
                               String meat,
                               Boolean egg,
                               String dairy,
                               String seafood,
                               String nut,
                               Boolean gluten,
                               String fruit,
                               String vegetable,
                               String other,
                               Long userId) {
        this.religion = religion;
        this.vegetarian = vegetarian;
        this.meat = meat;
        this.egg = egg;
        this.dairy = dairy;
        this.seafood = seafood;
        this.nut = nut;
        this.gluten = gluten;
        this.fruit = fruit;
        this.vegetable = vegetable;
        this.other = other;
        this.userId = userId;
    }

}
