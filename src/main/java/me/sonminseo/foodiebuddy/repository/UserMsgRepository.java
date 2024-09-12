package me.sonminseo.foodiebuddy.repository;


import me.sonminseo.foodiebuddy.entity.UserMsg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMsgRepository extends JpaRepository<UserMsg, Long> {

}

