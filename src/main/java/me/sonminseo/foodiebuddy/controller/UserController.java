package me.sonminseo.foodiebuddy.controller;

import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.dto.UserDr1RequestDto;
import me.sonminseo.foodiebuddy.dto.UserDr1ResponseDto;
import me.sonminseo.foodiebuddy.dto.UserSignUpRequestDto;
import me.sonminseo.foodiebuddy.dto.UserSignUpResponseDto;
import me.sonminseo.foodiebuddy.entity.Ingredients;
import me.sonminseo.foodiebuddy.entity.Restrictions;
import me.sonminseo.foodiebuddy.entity.User;
import me.sonminseo.foodiebuddy.service.IngredientsService;
import me.sonminseo.foodiebuddy.service.RestrictionsService;
import me.sonminseo.foodiebuddy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestrictionsService restrictionsService;
    private final IngredientsService ingredientsService;

    // 계정 생성

    @PostMapping("/signup")
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserSignUpResponseDto userSignUpResponseDto(@RequestBody final UserSignUpRequestDto userSignUpRequestDto) {
        Long userId = userService.signUp(userSignUpRequestDto);
        User findUser = userService.findUserById(userId);
        return UserSignUpResponseDto.from(findUser);
    }

    // 식이제한 입력 step1
    @PostMapping("/dr1")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDr1ResponseDto userDr1ResponseDto(@RequestBody final UserDr1RequestDto userDr1RequestDto) {

        Restrictions savedRestriction = restrictionsService.saveRestrictions(userDr1RequestDto);

        User user = userService.findUserById(userDr1RequestDto.getUserId());
        Ingredients savedIngredients = ingredientsService.saveIngredients(user, savedRestriction);

//        return UserDr1ResponseDto.from(savedRestriction);

        //        Ingredients ingredients = userService.receivedDr1(userDr1RequestDto);

//        User findUser = userService.findUserById(userId);

        return UserDr1ResponseDto.from(savedIngredients);


    }

    // 식이제한 입력 step2
}
