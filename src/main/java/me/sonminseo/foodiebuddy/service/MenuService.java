package me.sonminseo.foodiebuddy.service;

import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.dto.response.MenuResponseDto;
import me.sonminseo.foodiebuddy.entity.Menu;
import me.sonminseo.foodiebuddy.entity.User;
import me.sonminseo.foodiebuddy.repository.MenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional(readOnly = true)
    public Menu findMenuById(Long menuId) {
        return menuRepository.findById(menuId)
                .orElseThrow();
    }

    public Menu updateBookmark(Long menuId) {
        Menu menu = findMenuById(menuId);
        return menu.updateBookmark();
    }

    public Menu updateStar(Long menuId, int star) {
        Menu menu = findMenuById(menuId);
        return menu.updateStar(star);
    }

    @Transactional(readOnly = true)
    public List<MenuResponseDto> getMenuListByUser(User user) {
        List<MenuResponseDto> menuResponseDtoList = new ArrayList<>();
        List<Menu> menuList = menuRepository.findAllByUserAndIsBookmarked(user, true);

        menuList.stream().forEach(menu -> {
            MenuResponseDto menuResponseDto = MenuResponseDto.from(menu);
            menuResponseDtoList.add(menuResponseDto);
        });

        return menuResponseDtoList;

    }

}


