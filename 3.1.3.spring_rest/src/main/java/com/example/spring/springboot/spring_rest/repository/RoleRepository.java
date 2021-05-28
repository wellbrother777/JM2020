package com.example.spring.springboot.spring_rest.repository;

import com.example.spring.springboot.spring_rest.model.Role;
import com.example.spring.springboot.spring_rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
