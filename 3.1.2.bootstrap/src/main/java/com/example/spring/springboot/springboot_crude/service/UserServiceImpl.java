package com.example.spring.springboot.springboot_crude.service;

import com.example.spring.springboot.springboot_crude.model.Role;
import com.example.spring.springboot.springboot_crude.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.spring.springboot.springboot_crude.dao.UserDao;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    @Transactional
    public void addUser(User user) {

        if (user.getId() == null) {
            userDao.addUser(user);
        } else userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public List<Role> listRoles() {
        return userDao.listRoles();
    }

    @Override
    @Transactional
    public Role getRole(String role) {
        return userDao.getRole(role);
    }
}
