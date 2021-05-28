package com.example.spring.springboot.spring_rest.service;

import com.example.spring.springboot.spring_rest.model.Role;
import com.example.spring.springboot.spring_rest.model.User;
import com.example.spring.springboot.spring_rest.repository.RoleRepository;
import com.example.spring.springboot.spring_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
@EnableJpaRepositories(basePackages = {"com.example.spring.springboot.spring_rest.repository"})
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUserName(String username) {

        return userRepository.getUserByUsername(username);
    }

//    @Override
//    public User getUserByEmail(String email) {
//        return userRepository.getUserByEmail(email);
//    }

    @Override
    public void addUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        if (user.getId() == null) {
//            userDao.addUser(user);
//        } else userDao.updateUser(user);
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user, Long id) {
        User updatedUser = userRepository.findById(id).orElse(null);
        userRepository.saveAndFlush(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(String role) {
        return roleRepository.findByRole(role);
    }
}
