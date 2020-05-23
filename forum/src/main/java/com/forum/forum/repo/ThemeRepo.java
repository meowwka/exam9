package com.forum.forum.repo;

import com.forum.forum.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepo extends JpaRepository<Theme , Integer> {
}
