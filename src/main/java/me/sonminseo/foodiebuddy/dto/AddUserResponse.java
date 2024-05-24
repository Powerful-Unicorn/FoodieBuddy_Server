package me.sonminseo.foodiebuddy.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sonminseo.foodiebuddy.domain.User;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddUserResponse {
    private Long id;
    private String email;
//    private Date joinedDate;
//    private LocalDateTime createdDate;



    public AddUserResponse(Long id, String email, String nickname, Date joinedDate) {
        this.id = id;
        this.email = email;
//        this.joinedDate = joinedDate;
    }
    public static AddUserResponse from(User user) {
        return new AddUserResponse(
                user.getId(),
                user.getEmail());
//                user.getCreatedDate());
    }
}