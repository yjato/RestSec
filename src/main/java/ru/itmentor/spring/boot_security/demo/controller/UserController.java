package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/profile")
    public String viewProfile(Model model, Principal principal) {
        String username = principal.getName(); // Получаем имя текущего пользователя
        User user = userService.getUserByUsername(username); // Получаем пользователя по его имени
        model.addAttribute("user", user);
        return "user_profile"; // Возвращает страницу с профилем пользователя
    }
}
