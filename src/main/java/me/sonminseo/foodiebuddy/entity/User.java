package me.sonminseo.foodiebuddy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.List;


@Table(name = "user")
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Getter
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


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Chatflow> chatflows;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Menu> menus;

    // getters and setters
}
