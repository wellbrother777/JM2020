package com.example.spring.springboot.springboot_crude.service;

import com.example.spring.springboot.springboot_crude.dao.UserDao;
import com.example.spring.springboot.springboot_crude.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private UserDao userDaoImpl;

    public RoleServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    @Transactional
    public List<Role> listRoles() {
        return userDaoImpl.listRoles();
    }

    @Override
    @Transactional
    public Role findByRoleId(Long id) {
        return userDaoImpl.findByRoleId(id);
    }
}
