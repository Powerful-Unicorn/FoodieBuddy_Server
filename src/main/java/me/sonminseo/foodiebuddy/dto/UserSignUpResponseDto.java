package me.sonminseo.foodiebuddy.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.entity.User;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignUpResponseDto {

    private Long userId;
    private String email;
    private String username;

    public UserSignUpResponseDto(Long userId, String email, String username) {
        this.userId = userId;
        this.email = email;
        this.username = username;
    }

    public static UserSignUpResponseDto from(User user) {
        return new UserSignUpResponseDto(
                user.getUserId(),
                user.getEmail(),
                user.getUsername());
    }
}
