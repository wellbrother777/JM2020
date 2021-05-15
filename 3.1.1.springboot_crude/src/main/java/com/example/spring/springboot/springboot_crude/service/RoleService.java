package com.example.spring.springboot.springboot_crude.service;

import com.example.spring.springboot.springboot_crude.model.Role;


import java.util.List;

public interface RoleService {

    List<Role> listRoles();

    Role findByRoleId(Long id);
}
