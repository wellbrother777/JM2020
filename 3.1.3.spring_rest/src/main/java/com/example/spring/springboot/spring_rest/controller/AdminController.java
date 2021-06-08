package com.example.spring.springboot.spring_rest.controller;

import com.example.spring.springboot.spring_rest.model.Role;
import com.example.spring.springboot.spring_rest.model.User;
import com.example.spring.springboot.spring_rest.repository.UserRepository;
import com.example.spring.springboot.spring_rest.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private UserRepository userRepository;

    public AdminController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("newUser", new User());
        List<Role> roles = userService.listRoles();
        model.addAttribute("allRoles", roles);

        return "users";
    }

}
