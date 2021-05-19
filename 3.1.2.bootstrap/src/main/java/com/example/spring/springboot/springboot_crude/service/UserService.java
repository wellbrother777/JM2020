package com.example.spring.springboot.springboot_crude.service;

import com.example.spring.springboot.springboot_crude.model.Role;
import com.example.spring.springboot.springboot_crude.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByUserName(String userName);

    public User getUserByEmail(String email);

    public void addUser(User user);

    public void deleteUser(Long id);

    public User updateUser(User user);

    public User getUserById(Long id);

    public List<User> getUsers();

    List<Role> listRoles();

    public Role getRole(String role);

}
