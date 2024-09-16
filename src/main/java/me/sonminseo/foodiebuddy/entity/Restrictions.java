package me.sonminseo.foodiebuddy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "restrictions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restrictions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dr1Id;

    private String religion;

    private String vegetarian;

    //    @Column(nullable = false)
    @Column
    private Timestamp createdAt;

    //    @Column(nullable = false)
    @Column
    private Timestamp modifiedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    // getters and setters

    @Builder
    public Restrictions(User user, String religion, String vegetarian) {
        this.user = user;
        this.religion = religion;
        this.vegetarian = vegetarian;

    }

    public void updateRestrictions(String religion, String vegeterian) {
        this.religion = religion;
        this.vegetarian = vegeterian;

    }

    public Ingredients toIngredientsEntity(User user) {
        return Ingredients.builder()
                .user(user)
                .religion(religion)
                .vegeterian(vegetarian)
                .build();

    }
}
