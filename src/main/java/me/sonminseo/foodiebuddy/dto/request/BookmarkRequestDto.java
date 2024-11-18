package me.sonminseo.foodiebuddy.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookmarkRequestDto {

    private Long menuId;

    @Builder
    public BookmarkRequestDto(Long menuId) {
        this.menuId = menuId;
    }

}
