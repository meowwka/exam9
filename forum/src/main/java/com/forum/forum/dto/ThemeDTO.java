package com.forum.forum.dto;


import com.forum.forum.model.Theme;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ThemeDTO {
    private int id;
    private String name ;
    private String description;
    private String user;
    private String date;
    private int comments;

    public static ThemeDTO from (Theme theme){
        return builder()
                .id(theme.getId())
                .name(theme.getName())
                .description(theme.getDescription())
                .user(theme.getUser().getEmail())
                .date(theme.getDate().toString())
                .comments(theme.getCommentList().size())
                .user(theme.getUser().getEmail())
                .build();
    }

}
