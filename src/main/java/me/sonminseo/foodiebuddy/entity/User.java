package me.sonminseo.foodiebuddy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false)
    private Long userId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "religion")
    private String religion;

    @Column(name = "vegetarian", nullable = true)
    private String vegetarian;

    @Column(name = "meat")
    private String meat;

    @Column(name = "egg")
    private Boolean egg;

    @Column(name = "dairy")
    private String dairy;

    @Column(name = "seafood")
    private String seafood;

    @Column(name = "nut")
    private String nut;

    @Column(name = "gluten")
    private Boolean gluten;

    @Column(name = "fruit")
    private String fruit;

    @Column(name = "vegetable")
    private String vegetable;

    @Column(name = "other")
    private String other;


    @Builder
    public User(String email,
                String password,
                String username,
                String religion,
                String vegetarian,
                String meat,
                Boolean egg,
                String dairy,
                String seafood,
                String nut,
                Boolean gluten,
                String fruit,
                String vegetable,
                String other) {
        this.email = email;
        this.password = password;
        this.username = username;

        this.religion = religion;
        this.vegetarian = vegetarian;

        System.out.println("vegetarian");
        System.out.println(vegetarian);


    }

//    @Builder
//    public User(String religion, String vegetarian) {
//
//    }


}
