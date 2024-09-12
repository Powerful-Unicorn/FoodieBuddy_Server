package me.sonminseo.foodiebuddy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

@Entity
@Table(name = "user_msg")
public class UserMsg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMsgId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "chatflow_id", nullable = false)
    private Chatflow chatflow;

    @OneToOne(mappedBy = "userMsg", cascade = CascadeType.ALL)
    private Question question;

    // getters and setters
}
