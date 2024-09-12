package me.sonminseo.foodiebuddy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "chatflow")
public class Chatflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatflow_id", updatable = false, nullable = false)
    private Long chatflowId;

    @Column(name = "chatflow_type", updatable = false, nullable = false)
    private String chatflowType;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Timestamp createdAt;

    @Column(name = "modified_at", nullable = false)
    private Timestamp modifiedAt;

    @Column(name = "is_completed", updatable = false, nullable = false)
    private Boolean isCompleted;

    @Column(name = "completed_at", updatable = false)
    private Timestamp completedAt;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "chatflow", cascade = CascadeType.ALL)
    private List<UserMsg> userMsgs;

    @OneToMany(mappedBy = "chatflow", cascade = CascadeType.ALL)
    private List<ChatbotMsg> chatbotMsgs;

    // getters and setters

}