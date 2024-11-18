package me.sonminseo.foodiebuddy.repository;


import me.sonminseo.foodiebuddy.entity.Menu;
import me.sonminseo.foodiebuddy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findAllByUserAndIsBookmarked(User user, Boolean isBookmarked);
}

