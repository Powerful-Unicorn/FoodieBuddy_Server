package me.sonminseo.foodiebuddy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
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

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @OneToOne(mappedBy = "user")
    private Restrictions restrictions;

    @OneToOne(mappedBy = "user")
    private Ingredients ingredients;

//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Chatflow> chatflows;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Menu> menus;

    @Builder
    public User(String email, String password, String username, Timestamp createdAt) {

        this.email = email;
        this.password = password;
        this.username = username;
        this.createdAt = createdAt;

    }
//
//    public void updateUser(Long userId, String religion, String vegeterian) {
//        Ingredients ingredients = findIngredientsByUserId(userId);
//        ingredients.updateIngredients(religion, vegeterian);
//
//    }
}
