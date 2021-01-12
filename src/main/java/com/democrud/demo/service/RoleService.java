package com.democrud.demo.service;

import com.democrud.demo.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> allRoles();

    void add(Role role);

    void edit(Role role);

    void delete(Role role);

    Role getById(Long id);

    Role getByName(String name);
}

