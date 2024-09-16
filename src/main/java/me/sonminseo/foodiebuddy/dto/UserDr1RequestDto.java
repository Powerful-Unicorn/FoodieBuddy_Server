package me.sonminseo.foodiebuddy.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.entity.Restrictions;
import me.sonminseo.foodiebuddy.entity.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDr1RequestDto {

    private String religion;
    private String vegeterian;
    public Long userId;

    @Builder
    public UserDr1RequestDto(String religion, String vegeterian, Long userId) {
        this.religion = religion;
        this.vegeterian = vegeterian;
        this.userId = userId;

    }

    public Restrictions toEntity(User user) {
        return Restrictions.builder()
                .user(user)
                .religion(religion)
                .vegetarian(vegeterian)
                .build();
    }
}
