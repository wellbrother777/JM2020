package com.example.spring.springboot.springboot_crude.dao;


import com.example.spring.springboot.springboot_crude.model.Role;
import com.example.spring.springboot.springboot_crude.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;
    private final PasswordEncoder passwordEncoder;

    public UserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User findByUserName(String username) {
        User user = (User) entityManager.createQuery("from User u inner JOIN FETCH u.roles as roles where u.username = :username")
                .setParameter("username", username)
                .getSingleResult();
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        List<User> listUsers = entityManager
                        .createQuery("SELECT e FROM User e", User.class)
                        .getResultList();
        return listUsers;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> listRoles() {
        return entityManager
                .createQuery("SELECT e FROM Role e", Role.class)
                .getResultList();
    }

    @Override
    public void addUser(User user) {
       user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Override
    public User updateUser(User user) {
   //     user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.merge(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        User userToDelete = getUserById(id);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return (User) entityManager
                .createQuery("from User u inner JOIN FETCH u.roles as roles where u.email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public Role getRole(String role) {
        return entityManager
                .createQuery("select u from Role u where u.role=:role", Role.class)
                .setParameter("role", role)
                .getSingleResult();
    }
}
