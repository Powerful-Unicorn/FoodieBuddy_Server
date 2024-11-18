package me.sonminseo.foodiebuddy.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.entity.Menu;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuResponseDto {
    private Long menuId;
    private Boolean isBookmarked;
    private String name;
    private String pronunciation;
    private int star;

    public MenuResponseDto(Long menuId, Boolean isBookmarked, String name, String pronunciation, int star) {
        this.menuId = menuId;
        this.isBookmarked = isBookmarked;
        this.name = name;
        this.pronunciation = pronunciation;
        this.star = star;
    }

    public static MenuResponseDto from(Menu menu) {
        return new MenuResponseDto(
                menu.getMenuId(),
                menu.getIsBookmarked(),
                menu.getName(),
                menu.getPronunciation(),
                menu.getStar()
        );
    }
}
