package me.sonminseo.foodiebuddy.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.entity.Ingredients;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDr1ResponseDto {

    private String meat;

    private Boolean egg;

    private String dairy;
    private String seafood;
    private String nuts;

    private Boolean gluten;

    private String fruits;
    private String vegetables;
    private String other;

    public UserDr1ResponseDto(String meat,

                              Boolean egg,

                              String dairy, String seafood, String nuts,

                              Boolean gluten,

                              String fruits, String vegetables, String other) {

        this.meat = meat;
        this.egg = egg;
        this.dairy = dairy;
        this.seafood = seafood;
        this.nuts = nuts;
        this.gluten = gluten;
        this.fruits = fruits;
        this.vegetables = vegetables;
        this.other = other;

    }

    public static UserDr1ResponseDto from(Ingredients ingredients) {

        return new UserDr1ResponseDto(
                ingredients.getMeat(),
                ingredients.getEgg(),
                ingredients.getDairy(),
                ingredients.getSeafood(),
                ingredients.getNuts(),
                ingredients.getGluten(),
                ingredients.getFruits(),
                ingredients.getVegetables(),
                ingredients.getOther()
        );
    }


}
