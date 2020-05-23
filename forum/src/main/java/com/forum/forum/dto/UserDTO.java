package com.forum.forum.dto;

import com.forum.forum.model.User;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Data
public class UserDTO {
    private int id;
    private String name;
    private String email;

    public static UserDTO from(User user) {
        return builder().id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();

    }


}
