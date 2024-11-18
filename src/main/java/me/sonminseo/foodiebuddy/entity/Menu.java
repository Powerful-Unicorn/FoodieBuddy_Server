package me.sonminseo.foodiebuddy.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Menu updateBookmark() {
        Boolean tmp = this.isBookmarked;
        tmp = !tmp;
        this.isBookmarked = tmp;

        return this;
    }

    public Menu updateStar(int star) {
        this.star = star;
        return this;
    }


//    @Builder
//    public Menu(String name,
//                String pronunciation,
//                int star,
//                Boolean isBookmarked,
//                User user) {
//        this.name = name;
//        this.pronunciation = pronunciation;
//        this.star = star;
//
//        this.isBookmarked = isBookmarked;
//        this.user = user;
//
//    }
}

