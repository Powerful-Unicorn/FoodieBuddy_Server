package me.sonminseo.foodiebuddy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")
public class ModelQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false)
    private String content;

    @OneToOne
    @JoinColumn(name = "user_msg_id", nullable = false)
    private UserMsg userMsg;

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    private ModelAnswer modelAnswer;

    // getters and setters
}
