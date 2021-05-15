package com.example.spring.springboot.springboot_crude.dao;


import com.example.spring.springboot.springboot_crude.model.Role;
import com.example.spring.springboot.springboot_crude.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;
    private final PasswordEncoder passwordEncoder;

    public UserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<User> findByUserName(String userName) {
        User user = entityManager.createQuery("select e from User e where e.userName = ?1", User.class)
                .setParameter(1, userName)
                .getSingleResult();
        return Optional.of(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        List<User> listUsers =
                entityManager.createQuery("SELECT e FROM User e", User.class).getResultList();
        return listUsers;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> listRoles() {
        return entityManager.createQuery("SELECT e FROM Role e", Role.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.merge(user);
    }

    @Override
    public void saveUser(User user) {
        if(user.getId() == null) {
            addUser(user);
        } else {
            updateUser(user);
        }
    }

    @Override
    public Role findByRoleId(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        User userToDelete = getUser(id);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }
}
