package me.sonminseo.foodiebuddy.dto.response;

import lombok.Getter;
import me.sonminseo.foodiebuddy.entity.Menu;

@Getter
public class BookmarkResponseDto {
    private Long userId;
    private Long menuId;
    private Boolean isBookmarked;

    public BookmarkResponseDto(Long userId, Long menuId, Boolean isBookmarked) {
        this.userId = userId;
        this.menuId = menuId;
        this.isBookmarked = isBookmarked;
    }

    public static BookmarkResponseDto from(Menu menu) {
        return new BookmarkResponseDto(
                menu.getUser().getUserId(),
                menu.getMenuId(),
                menu.getIsBookmarked()
        );
    }
}
