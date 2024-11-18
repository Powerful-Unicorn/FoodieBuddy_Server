package me.sonminseo.foodiebuddy.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StarRequestDto {
    private Long menuId;
    private int star;

    @Builder
    public StarRequestDto(Long menuId, int star) {
        this.menuId = menuId;
        this.star = star;
    }

}
