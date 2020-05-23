package com.forum.forum.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 128)
    private String name;

    @Column(length = 128)
    private String description;

    @Column(name = "date")
    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy ="theme")
    List<Comment> commentList;

//    public static Theme make(User u) {
//        Random r = new Random();
//        return builder()
//                .name(Generator.makePassword() + " " + Generator.makeName())
//                .description(Generator.makeDescription())
//                .user(u)
//                .date(LocalDateTime.now().minusDays(r.nextInt(20) + 1))
//                .build();
//    }
//    public void plusComent() {
//        this.getCommentList().size() = ;
//    }
}
