package com.example.spring.springboot.spring_rest.controller;

import com.example.spring.springboot.spring_rest.model.User;
import com.example.spring.springboot.spring_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {


    private UserService userService;

    @Autowired
    public RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> showUser(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/infoUser")
    @ResponseBody
    public User infoUser(@AuthenticationPrincipal User user_auth) {
        User user = userService.findByUserName(user_auth.getUsername());
        return user;
    }

    @GetMapping(value = "/findUser/{id}")
    public User findUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping(value = "/updateUser")
    public ResponseEntity<?> editUser(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addUser")
    private ResponseEntity<User> addUser(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
