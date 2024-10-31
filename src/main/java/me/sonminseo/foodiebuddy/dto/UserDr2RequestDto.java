package me.sonminseo.foodiebuddy.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDr2RequestDto {

    private Long userId;
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
    UserDr2RequestDto(String meat,
                      Boolean egg,
                      String dairy,
                      String seafood,
                      String nut,
                      Boolean gluten,
                      String fruit,
                      String vegetable,
                      String other,
                      Long userId
    ) {
        this.meat = meat;
        this.egg = egg;
        this.dairy = dairy;
        this.seafood = seafood;
        this.nut = nut;
        this.gluten = gluten;
        this.fruit = fruit;
        this.vegetable = vegetable;
        this.other = other;
//        this.userId = userId;
    }


}
