package com.example.spring.springboot.springboot_crude.controller;

import com.example.spring.springboot.springboot_crude.model.Role;
import com.example.spring.springboot.springboot_crude.model.User;
import com.example.spring.springboot.springboot_crude.service.UserService;
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

    public AdminController(UserService userService) {
        this.userService = userService;
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

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String add(@ModelAttribute("user") User user,
                      @RequestParam(value = "newRole",
                      required = false) String[] role) {
        userService.addUser(user);
        return "redirect:/admin/";
    }

    @GetMapping("/update")
    public String editUser(@RequestParam(value = "id") Long id,
                            Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", userService.listRoles());
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user,
                             @RequestParam(name = "allRoles",
                             required = false) String[] roles) {
        userService.updateUser(user);
        return "redirect:/admin/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam (value = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/";
    }

    @GetMapping("/{id}")
    public String showUser(Principal principal, Model model){
        User username = userService.findByUserName(principal.getName());
        model.addAttribute("user", username);
        return "user";
    }

}
