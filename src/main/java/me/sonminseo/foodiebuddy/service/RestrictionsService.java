package me.sonminseo.foodiebuddy.service;

import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.dto.UserDr1RequestDto;
import me.sonminseo.foodiebuddy.entity.Restrictions;
import me.sonminseo.foodiebuddy.entity.User;
import me.sonminseo.foodiebuddy.repository.RestrictionsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestrictionsService {

    private final RestrictionsRepository restrictionsRepository;

    private final UserService userService;

    public Restrictions saveRestrictions(UserDr1RequestDto userDr1RequestDto) {
        User user = userService.findUserById(userDr1RequestDto.userId);
        Restrictions restrictions = userDr1RequestDto.toEntity(user);
        Restrictions savedRestriction = restrictionsRepository.save(restrictions);
        return savedRestriction;
    }

}
