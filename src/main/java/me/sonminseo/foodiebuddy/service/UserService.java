package me.sonminseo.foodiebuddy.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.dto.UserDr1RequestDto;
import me.sonminseo.foodiebuddy.entity.Ingredients;
import me.sonminseo.foodiebuddy.entity.Restrictions;
import me.sonminseo.foodiebuddy.entity.User;
import me.sonminseo.foodiebuddy.repository.IngredientsRepository;
import me.sonminseo.foodiebuddy.repository.RestrictionsRepository;
import me.sonminseo.foodiebuddy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RestrictionsRepository restrictionsRepository;
    private final IngredientsRepository ingredientsRepository;


    public Ingredients receivedDr1(UserDr1RequestDto userDr1RequestDto) {

        Restrictions restrictions = findRestrictionsByUserId(userDr1RequestDto.userId);
        Ingredients ingredients = findIngredientsByUserId(userDr1RequestDto.userId);

        restrictions.updateRestrictions(userDr1RequestDto.getReligion(), userDr1RequestDto.getVegeterian());
        ingredients.updateIngredients(userDr1RequestDto.getReligion(), userDr1RequestDto.getVegeterian());

        return ingredients;
    }

    @Transactional(readOnly = true)
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("해당 id를 가진 User를 찾을 수 없습니다. userId= " + userId));

    }

    @Transactional(readOnly = true)
    public Restrictions findRestrictionsByUserId(Long userId) {
        return restrictionsRepository.findByUserUserId(userId);
        // .orElseThrow(() -> new EntityNotFoundException("찾을 수 없습니다. userId= " + userId));
        //

    }

    @Transactional(readOnly = true)
    public Ingredients findIngredientsByUserId(Long userId) {
        return ingredientsRepository.findByUserUserId(userId);
        // .orElseThrow(() -> new EntityNotFoundException("찾을 수 없습니다. userId= " + userId));

    }
}


