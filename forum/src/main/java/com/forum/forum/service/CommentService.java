package com.forum.forum.service;

import com.forum.forum.dto.CommentDTO;
import com.forum.forum.model.Comment;
import com.forum.forum.repo.CommentRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;
    public Page<CommentDTO> getComments(Integer theme_id, Pageable pageable){
        return commentRepo.findAllByThemeId(theme_id, pageable).map(CommentDTO::from);
    }

    public void saveC(Comment comment){
        commentRepo.save(comment);
    }
}
