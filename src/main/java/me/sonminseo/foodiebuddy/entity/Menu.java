package me.sonminseo.foodiebuddy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String pronunciation;

    @Column(nullable = false)
    private int star;

    @Column(nullable = false)
    private Boolean isBookmarked;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    // getters and setters
}
