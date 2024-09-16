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
@Table(name = "ingredients")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dr2Id;

    private String meat;

    @Column(nullable = false)
    private Boolean egg;

    private String dairy;

    private String seafood;

    private String nuts;

    @Column(nullable = false)
    private Boolean gluten;

    private String fruits;

    private String vegetables;

    private String other;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;


    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Timestamp modifiedAt;

    // getters and setters


    @Builder
    public Ingredients(User user, String religion, String vegeterian) {

        if (vegeterian.equals("pescatarian")) {
            this.meat = "all kinds";
            this.egg = false;
            this.dairy = "";
            this.seafood = "";
            this.nuts = "";
            this.gluten = false;
            this.fruits = "";
            this.vegetables = "";
            this.other = "";

        }

    }

//    public Ingredients updateIngredients(String religion, String vegeterian) {
//
//        if (vegeterian.equals("pescatarian")) {
//            this.meat = "all kinds";
//            this.egg = false;
//            this.dairy = "";
//            this.seafood = "";
//            this.nuts = "";
//            this.gluten = false;
//            this.fruits = "";
//            this.vegetables = "";
//            this.other = "";
//
//        }
//
//
//    }
}
