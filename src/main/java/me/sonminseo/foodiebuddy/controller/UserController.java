package me.sonminseo.foodiebuddy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.dto.UserDr1RequestDto;
import me.sonminseo.foodiebuddy.dto.UserDr1ResponseDto;
import me.sonminseo.foodiebuddy.dto.UserDr2RequestDto;
import me.sonminseo.foodiebuddy.dto.UserSignUpRequestDto;
import me.sonminseo.foodiebuddy.dto.UserSignUpResponseDto;
import me.sonminseo.foodiebuddy.entity.User;
import me.sonminseo.foodiebuddy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "USER", description = "user와 관련된 API")
public class UserController {

    private final UserService userService;

    // 계정 생성
    @PostMapping("/signup")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "신규 유저 추가", description = "신규유저 추가 요청")
    public UserSignUpResponseDto userSignUpResponseDto(@RequestBody final UserSignUpRequestDto userSignUpRequestDto) {
        Long userId = userService.signUp(userSignUpRequestDto);
        User findUser = userService.findUserById(userId);
        return UserSignUpResponseDto.from(findUser);
    }

    // 식이제한 입력 step1
    @PostMapping("/dr1")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "식이제한 입력 step1", description = "종교 정보, 채식 정보 입력")
    public UserDr1ResponseDto userDr1ResponseDto(@RequestBody final UserDr1RequestDto userDr1RequestDto) {

        User findUser = userService.findUserById(userDr1RequestDto.getUserId());
        User user = userService.saveRestrictions(userDr1RequestDto, findUser);

        System.out.println(user.getUserId());
        System.out.println(user.getVegetarian());

        return UserDr1ResponseDto.from(user);

    }

    // 식이제한 입력 step2
    @PutMapping("/dr2")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "식이제한 입력 step2", description = "섭취 불가능한 재료 정보 입력 (string: 섭취 불가한 재료 / boolean: 섭취 불가한 경우 true) ")
    public UserDr1ResponseDto userDr2ResponseDto(@RequestBody final UserDr2RequestDto userDr2RequestDto) {
        User findUser = userService.findUserById(userDr2RequestDto.getUserId());
        User user = userService.saveIngredients(userDr2RequestDto, findUser);

        return UserDr1ResponseDto.from(user);

    }
}
