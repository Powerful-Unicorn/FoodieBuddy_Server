package me.sonminseo.foodiebuddy.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.dto.UserDr1RequestDto;
import me.sonminseo.foodiebuddy.dto.UserSignUpRequestDto;
import me.sonminseo.foodiebuddy.entity.User;
import me.sonminseo.foodiebuddy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public Long signUp(UserSignUpRequestDto userSignUpRequestDto) {

        User user = userRepository.save(userSignUpRequestDto.toEntity());
        return user.getUserId();
    }


    @Transactional(readOnly = true)
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("해당 id를 가진 User를 찾을 수 없습니다. userId= " + userId));

    }

    public User saveRestrictions(UserDr1RequestDto userDr1RequestDto) {
        User user = userRepository.save(userDr1RequestDto.toEntity());

        return user;

    }

//    @Transactional(readOnly = true)
//    public Restrictions findRestrictionsByUser(User user) {
//        return restrictionsRepository.findByUser(user);
//        // .orElseThrow(() -> new EntityNotFoundException("찾을 수 없습니다. userId= " + userId));
//        //
//
//    }

//    @Transactional(readOnly = true)
//    public Ingredients findIngredientsByUserId(Long userId) {
//        return ingredientsRepository.findByUserUserId(userId);
//        // .orElseThrow(() -> new EntityNotFoundException("찾을 수 없습니다. userId= " + userId));
//
//    }
}


