package com.forum.forum.service;

import com.forum.forum.dto.ThemeDTO;
import com.forum.forum.dto.UserDTO;
import com.forum.forum.model.Theme;
import com.forum.forum.repo.ThemeRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ThemeService {
    private final ThemeRepo themeRepo;

    public void saveThemes(Theme theme){
        themeRepo.save(theme);

    }

    public ThemeDTO saveTheme(Theme theme){
            var themes = Theme.builder()
                    .name(theme.getName())
                    .date(theme.getDate())
                    .description(theme.getDescription())
                    .user(theme.getUser())
                    .commentList(theme.getCommentList())
                    .build();
            return ThemeDTO.from(themes);
    }

    public Page<ThemeDTO> getAll(Pageable pageable) {
        return themeRepo.findAll(pageable).map(ThemeDTO::from);
    }

    public Theme findThemeById(Integer themeId){
        return themeRepo.findById(themeId).get();
    }

    public ThemeDTO getThemeById(Integer themeId){
        return ThemeDTO.from(themeRepo.findById(themeId).get());
    }
}
