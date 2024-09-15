package me.sonminseo.foodiebuddy.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.entity.User;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignUpRequestDto {


    private String email;
    private String password;
    private String username;

    @Builder
    public UserSignUpRequestDto(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }


    public User toEntity() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .username(this.username)
                .build();
    }
}
