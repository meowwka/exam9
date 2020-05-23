package com.forum.forum.repo;

import com.forum.forum.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    Page<Comment> findAllByThemeId(Integer themeId, Pageable pageable);

}
