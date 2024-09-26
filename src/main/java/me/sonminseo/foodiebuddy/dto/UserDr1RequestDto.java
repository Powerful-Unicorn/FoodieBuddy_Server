package me.sonminseo.foodiebuddy.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.entity.User;
import me.sonminseo.foodiebuddy.service.UserService;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class UserDr1RequestDto {

    private UserService userService;

    private String religion;
    private String vegetarian;
    public Long userId;

    @Builder
    public UserDr1RequestDto(String religion, String vegetarian, Long userId) {
        this.religion = religion;
        this.vegetarian = vegetarian;
//        this.userId = userId;
    }

    public User toEntity() {
//        User user = userService.findUserById(userId);
        System.out.println(User.builder());
        return User.builder()
//
//                .email(user.getEmail())
//                .password(user.getPassword())
//                .username(user.getUsername())

                .religion(this.religion)
                .vegetarian(this.vegetarian)

//                .meat(user.getMeat())

                .build();


    }

//    public User toEntity(User user) {
//        return User.builder()
//                .user(user)
//                .religion(religion)
//                .vegetarian(vegeterian)
//                .build();
//    }
}
