package me.sonminseo.foodiebuddy.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.entity.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDr1RequestDto {

    private String religion;
    private String vegetarian;
    private Long userId;

    @Builder
    public UserDr1RequestDto(String religion, String vegetarian, Long userId) {
        this.religion = religion;
        this.vegetarian = vegetarian;
    }

    public User toEntity() {
        System.out.println(User.builder());
        return User.builder()
                .religion(this.religion)
                .vegetarian(this.vegetarian)
                .build();


    }

}
