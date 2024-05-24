package me.sonminseo.foodiebuddy.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.sonminseo.foodiebuddy.domain.User;
import me.sonminseo.foodiebuddy.dto.AddUserRequest;
import me.sonminseo.foodiebuddy.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {

//        log.info("");

        if (existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 email입니다. " + dto.getEmail());
        }

        if (dto.getPassword() == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }


        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    
    public Long signUp(AddUserRequest dto) {


        if (existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 email입니다." + dto.getEmail());
        }


        User user = userRepository.save(dto.toEntity());
        return user.getId();
    }

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 id를 가진 Account를 찾을 수 없습니다.id="+id));
    }

}
