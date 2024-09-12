package me.sonminseo.foodiebuddy.repository;


import java.util.Optional;
import me.sonminseo.foodiebuddy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}

