package me.sonminseo.foodiebuddy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.dto.request.BookmarkRequestDto;
import me.sonminseo.foodiebuddy.dto.request.StarRequestDto;
import me.sonminseo.foodiebuddy.dto.response.BookmarkResponseDto;
import me.sonminseo.foodiebuddy.dto.response.MenuResponseDto;
import me.sonminseo.foodiebuddy.dto.response.StarResponseDto;
import me.sonminseo.foodiebuddy.entity.Menu;
import me.sonminseo.foodiebuddy.service.MenuService;
import me.sonminseo.foodiebuddy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
@Tag(name = "USER", description = "user와 관련된 API")
public class MenuController {

    private final UserService userService;
    private final MenuService menuService;

    // 북마크 수정 patch
    @PatchMapping("/bookmark/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "북마크 변경", description = "북마크 여부(true/false)를 변경")
    public BookmarkResponseDto bookmarkResponseDto(@PathVariable Long userId, @RequestBody final BookmarkRequestDto bookmarkRequestDto) {
        Menu menu = menuService.updateBookmark(bookmarkRequestDto.getMenuId());
        return BookmarkResponseDto.from(menu);
    }


    // 별점 수정 patch
    @PatchMapping("/star/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "별점 변경", description = "별점 값(0-5)을 변경 (디폴트: 0)")
    public StarResponseDto starResponseDto(@PathVariable Long userId, @RequestBody final StarRequestDto starRequestDto) {
        Menu menu = menuService.updateStar(starRequestDto.getMenuId(), starRequestDto.getStar());
        return StarResponseDto.from(menu);
    }

    // 북마크 및 별점 조회 get
    @GetMapping("/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "북마크한 메뉴 조회", description = "북마크한 메뉴의 정보를 조회")
    public List<MenuResponseDto> menuResponseDtoList(@PathVariable Long userId) {
        return menuService.getMenuListByUser(userService.findUserById(userId));
    }


}
