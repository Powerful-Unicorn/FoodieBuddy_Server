package me.sonminseo.foodiebuddy.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
