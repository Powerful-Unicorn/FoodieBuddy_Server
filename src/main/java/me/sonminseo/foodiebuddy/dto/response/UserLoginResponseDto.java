package me.sonminseo.foodiebuddy.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.entity.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginResponseDto {

    private Long userId;
    private String email;
//    private String username;

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


    public UserLoginResponseDto(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
//        this.username = user.getUsername();
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

    public static UserLoginResponseDto from(User user) {
        return new UserLoginResponseDto(user);
    }
}
