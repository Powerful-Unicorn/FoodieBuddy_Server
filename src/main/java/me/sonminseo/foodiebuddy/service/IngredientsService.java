package me.sonminseo.foodiebuddy.service;


import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.entity.Ingredients;
import me.sonminseo.foodiebuddy.entity.Restrictions;
import me.sonminseo.foodiebuddy.entity.User;
import me.sonminseo.foodiebuddy.repository.IngredientsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class IngredientsService {

    private final IngredientsRepository ingredientsRepository;
    private final UserService userService;

    public Ingredients saveIngredients(User user, Restrictions savedRestriction) {

        Ingredients ingredients = savedRestriction.toIngredientsEntity(user);
        Ingredients savedIngredients = ingredientsRepository.save(ingredients);
        return savedIngredients;

    }
}
