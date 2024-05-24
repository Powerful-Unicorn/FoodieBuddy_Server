package me.sonminseo.foodiebuddy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.domain.User;
import me.sonminseo.foodiebuddy.dto.AddUserRequest;
import me.sonminseo.foodiebuddy.dto.AddUserResponse;
import me.sonminseo.foodiebuddy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public AddUserResponse signup(@RequestBody AddUserRequest request) {
        if (request.getPassword() == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        Long id = userService.save(request);
//        Long id = accountService.signUp(requestDto);
        User findUser = userService.findUserById(id);
        return AddUserResponse.from(findUser);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }




//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
//        return "redirect:/login";
//    }

}
