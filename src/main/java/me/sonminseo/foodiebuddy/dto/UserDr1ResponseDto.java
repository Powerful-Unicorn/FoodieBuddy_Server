package me.sonminseo.foodiebuddy.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.entity.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDr1ResponseDto { // UserDr2ResponseDto 로도 이거 사용 ~

    private String meat;

    private Boolean egg;

    private String dairy;
    private String seafood;
    private String nut;

    private Boolean gluten;

    private String fruit;
    private String vegetable;
    private String other;

    public UserDr1ResponseDto(String meat,

                              Boolean egg,

                              String dairy, String seafood, String nut,

                              Boolean gluten,

                              String fruit, String vegetable, String other) {

        this.meat = meat;
        this.egg = egg;
        this.dairy = dairy;
        this.seafood = seafood;
        this.nut = nut;
        this.gluten = gluten;
        this.fruit = fruit;
        this.vegetable = vegetable;
        this.other = other;

    }

    public static UserDr1ResponseDto from(User user) {

        return new UserDr1ResponseDto(
                user.getMeat(),
                user.getEgg(),
                user.getDairy(),
                user.getSeafood(),
                user.getNut(),
                user.getGluten(),
                user.getFruit(),
                user.getVegetable(),
                user.getOther()
        );
    }


}
