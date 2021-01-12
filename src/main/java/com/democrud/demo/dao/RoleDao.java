package com.democrud.demo.dao;

import com.democrud.demo.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> allRoles();

    void add(Role role);

    void edit(Role role);

    void delete(Role role);

    Role getByid(Long id);

    Role getByName(String name);
}


