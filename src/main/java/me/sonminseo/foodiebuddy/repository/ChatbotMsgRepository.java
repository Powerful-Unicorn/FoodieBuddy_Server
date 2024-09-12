package me.sonminseo.foodiebuddy.repository;


import me.sonminseo.foodiebuddy.entity.ChatbotMsg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatbotMsgRepository extends JpaRepository<ChatbotMsg, Long> {

}

