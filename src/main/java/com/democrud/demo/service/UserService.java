package com.democrud.demo.service;

import com.democrud.demo.model.Role;
import com.democrud.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> showAll();

    void addAndSave(User user);

    void delete(Long id);

    void edit(User user);

    User getById(Long id);

    User getUserByName(String login);

    Role getRoleByName(String role);
}
