package com.example.spring.springboot.springboot_crude.controller;

import com.example.spring.springboot.springboot_crude.model.User;
import com.example.spring.springboot.springboot_crude.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userPage(Model model, Principal principal) {
        String username = principal.getName();
        Optional<User> user = userService.findUserByUserName(username);
        model.addAttribute("user", user.get());
        return "user";
    }
}
