package com.forum.forum.controller;

import com.forum.forum.model.Comment;
import com.forum.forum.model.Theme;
import com.forum.forum.model.UserRegisterForm;
import com.forum.forum.repo.UserRepo;
import com.forum.forum.service.CommentService;
import com.forum.forum.service.PropertiesService;
import com.forum.forum.service.ThemeService;
import com.forum.forum.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
//@RequestMapping("/")
@AllArgsConstructor
public class MainController {
    private final UserService userService;
    private final ThemeService themeService;
    private final UserRepo userRepo;
    private final PropertiesService propertiesService;
    private final CommentService commentService;
    private static <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri, String themes) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink", constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }
        if (list.hasPrevious()) {
            model.addAttribute("prevPageLink", constructPageUri(uri, list.previousPageable().getPageNumber(), list.previousPageable().getPageSize()));
        }
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        model.addAttribute(themes, list.getContent());
        model.addAttribute("defaultPageSize", pageSize);
    }

    private static String constructPageUri(String uri, int page, int size) {
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }

    @GetMapping("/")
    public String getIndex(HttpServletRequest uriBuilder, Model model, Pageable pageable, Principal principal){
        var themes =themeService.getAll(pageable);
        var uri =uriBuilder.getRequestURI();
        constructPageable(themes, propertiesService.getDefaultPageSize(), model, uri, "themes");


        if(uriBuilder.getUserPrincipal() != null) {
            var user = userService.getByEmail(uriBuilder.getUserPrincipal().getName());
            model.addAttribute("user", user);
        }
        return "index";
    }

    @GetMapping("/create")
    public String themes(HttpServletRequest uriBuilder, Model model){
        if(uriBuilder.getUserPrincipal() != null) {
            var user = userService.getByEmail(uriBuilder.getUserPrincipal().getName());
            model.addAttribute("user", user);
        }

        return "create";
    }
    @PostMapping("/create")
    public String postMapping( @RequestParam String name, @RequestParam String description
    ){

            Theme theme = new Theme();
            theme.setName(name);
            theme.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
            theme.setDescription(description);
            themeService.saveThemes(theme);

        return "redirect:/";

    }

    @GetMapping("/theme/{theme_id}")
   public String themePage(@PathVariable("theme_id") Integer theme_id, Model model, Pageable pageable,
                           HttpServletRequest uriBuilder){
         model.addAttribute("theme", themeService.getThemeById(theme_id));
         var comments = commentService.getComments(theme_id, pageable);
        var uri = uriBuilder.getRequestURI();
           constructPageable(comments, propertiesService.getDefaultPageSize(), model, uri, "comments");
        if(uriBuilder.getUserPrincipal() != null) {
            var user = userService.getByEmail(uriBuilder.getUserPrincipal().getName());
            model.addAttribute("user", user);
        }         return "theme";
   }
    @GetMapping("/registration")
    public String pageRegisterUser(Model model, HttpServletRequest uriBuilder){
        if(!model.containsAttribute("form")){
            model.addAttribute("form", new UserRegisterForm());
        }
        if(uriBuilder.getUserPrincipal() != null) {
            var user = userService.getByEmail(uriBuilder.getUserPrincipal().getName());
            model.addAttribute("user", user);
        }
        return "registration";
    }

    @RequestMapping("/registration")
    public String register(@Valid UserRegisterForm form,
                           BindingResult validationResult,
                           RedirectAttributes attributes) {
        if (validationResult.hasFieldErrors()) {
            var list = validationResult.getFieldErrors();
            attributes.addFlashAttribute("errors", list);
            return "redirect:/registration";
        }
        if (userService.checkUser(form)) {
            attributes.addFlashAttribute("user", form);
            return "redirect:/";
        }
        attributes.addFlashAttribute("user", form);

        userService.register(form);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model){
        model.addAttribute("error",error);
        return "login";
    }
    @GetMapping("/profile")
    public String getUser(Model model, Principal principal) {
        var user = userService.getByEmail(principal.getName());
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/theme/add/comment")
    public String addComment(@RequestParam("theme_id") Integer theme_id, @RequestParam("text") String text){
        Comment comment = new Comment();
        comment.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
        comment.setText(text);
        comment.setTheme(themeService.findThemeById(theme_id));
        commentService.saveC(comment);
        return "redirect:/";
    }
}
