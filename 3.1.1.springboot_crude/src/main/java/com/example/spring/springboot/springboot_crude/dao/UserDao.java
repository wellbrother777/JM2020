package com.example.spring.springboot.springboot_crude.dao;

import com.example.spring.springboot.springboot_crude.model.Role;
import com.example.spring.springboot.springboot_crude.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<User> findByUserName(String userName);

    public List<User> getUsers();

    public void addUser(User user);

    public void updateUser(User user);

    public void saveUser(User user);

    public User getUser(Long id);

    public void deleteUser(Long id);

    List<Role> listRoles();

    Role findByRoleId(Long id);

}
