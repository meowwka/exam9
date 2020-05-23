package com.forum.forum.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "comment_date")
    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Theme theme;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

//    public static Comment make(User u, Theme t) {
//        Random r = new Random();
//        return builder()
//                .text(Generator.makeDescription())
//                .user(u)
//                .theme(t)
//                .date(LocalDateTime.now().minusDays(r.nextInt(20) + 1))
//                .build();
//    }

}
