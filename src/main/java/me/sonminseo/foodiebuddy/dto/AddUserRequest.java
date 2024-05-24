package me.sonminseo.foodiebuddy.dto;

import lombok.Getter;
import lombok.Setter;
import me.sonminseo.foodiebuddy.domain.User;

@Setter
@Getter
public class AddUserRequest {
    private String email;
    private String password;

    public User toEntity() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }

}
