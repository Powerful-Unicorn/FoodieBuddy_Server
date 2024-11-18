package me.sonminseo.foodiebuddy.dto.response;

import lombok.Getter;
import me.sonminseo.foodiebuddy.entity.Menu;

@Getter
public class StarResponseDto {
    private Long userId;
    private Long menuId;
    private int star;

    public StarResponseDto(Long userId, Long menuId, int star) {
        this.userId = userId;
        this.menuId = menuId;
        this.star = star;
    }

    public static StarResponseDto from(Menu menu) {
        return new StarResponseDto(
                menu.getUser().getUserId(),
                menu.getMenuId(),
                menu.getStar()
        );
    }
}
