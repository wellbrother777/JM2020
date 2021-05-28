package com.example.spring.springboot.spring_rest.service;

import com.example.spring.springboot.spring_rest.model.Role;
import com.example.spring.springboot.spring_rest.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {

    List<User> getUsers();

    User getUserById(Long id);

    User findByUserName(String userName);

//    User getUserByEmail(String email);

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user, Long id);

    List<Role> listRoles();

    Role getRole(String role);

}
