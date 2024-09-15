package me.sonminseo.foodiebuddy.repository;


import me.sonminseo.foodiebuddy.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {

}

