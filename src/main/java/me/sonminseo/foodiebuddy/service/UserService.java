package me.sonminseo.foodiebuddy.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.dto.UserDr1RequestDto;
import me.sonminseo.foodiebuddy.dto.UserDr2RequestDto;
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

    /*신규 유저 추가*/
    public Long signUp(UserSignUpRequestDto userSignUpRequestDto) {
        User user = userRepository.save(userSignUpRequestDto.toEntity());
        return user.getUserId();
    }

    /*pk로 유저 찾기*/
    @Transactional(readOnly = true)
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("해당 id를 가진 User를 찾을 수 없습니다. userId= " + userId));

    }


    /*식이제한 추가 1단계*/
    public User saveRestrictions(UserDr1RequestDto userDr1RequestDto, User user) {

        System.out.println(userDr1RequestDto.getVegetarian());

        user.setReligion(userDr1RequestDto.getReligion());
        user.setVegetarian(userDr1RequestDto.getVegetarian());

        if (user.getVegetarian().equals("pescatarian")) {

            user.setMeat("all kinds");
            user.setEgg(false);
            user.setDairy("");
            user.setSeafood("");
            user.setNut("");
            user.setGluten(false);
            user.setFruit("");
            user.setVegetable("");
            user.setOther("");

        }
        return userRepository.save(user);
    }


    public User saveIngredients(UserDr2RequestDto userDr2RequestDto, User user) {

        user.setMeat(userDr2RequestDto.getMeat());
        user.setEgg(userDr2RequestDto.getEgg());
        user.setDairy(userDr2RequestDto.getDairy());
        user.setSeafood(userDr2RequestDto.getSeafood());
        user.setNut(userDr2RequestDto.getNut());
        user.setGluten(userDr2RequestDto.getGluten());
        user.setFruit(userDr2RequestDto.getFruit());
        user.setVegetable(userDr2RequestDto.getVegetable());
        user.setOther(userDr2RequestDto.getOther());

        return userRepository.save(user);

    }
}


