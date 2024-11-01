package me.sonminseo.foodiebuddy.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.entity.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDrPutResponseDto {

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

    public UserDrPutResponseDto(User user) {
        this.userId = user.getUserId();
        this.religion = user.getReligion();
        this.vegetarian = user.getVegetarian();
        this.meat = user.getMeat();
        this.egg = user.getEgg();
        this.dairy = user.getDairy();
        this.seafood = user.getSeafood();
        this.nut = user.getNut();
        this.gluten = user.getGluten();
        this.fruit = user.getFruit();
        this.vegetable = user.getVegetable();
        this.other = user.getOther();

    }

    public static UserDrPutResponseDto from(User user) {
        return new UserDrPutResponseDto(user);
    }
}
