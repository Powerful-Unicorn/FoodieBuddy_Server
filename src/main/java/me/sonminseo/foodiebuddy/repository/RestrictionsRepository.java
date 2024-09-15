package me.sonminseo.foodiebuddy.repository;


import me.sonminseo.foodiebuddy.entity.Restrictions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestrictionsRepository extends JpaRepository<Restrictions, Long> {

    Restrictions findByUserUserId(Long userId);


}

