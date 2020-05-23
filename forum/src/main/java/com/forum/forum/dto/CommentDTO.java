package com.forum.forum.dto;

import com.forum.forum.model.Comment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDTO {
private int id;
private String text;
private String date;
private String user;

    public static CommentDTO from(Comment comment) {
        return builder()
                .id(comment.getId())
                .user(comment.getUser().getEmail())
                .date(comment.getDate().toString())
                .text(comment.getText())
                .build();
    }

}
