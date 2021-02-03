package com.democrud.demo.service;

import com.democrud.demo.model.Role;
import com.democrud.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    UserDetails loadUserByUsername(String login);

    Role getRole(String role);

    List<User> listAllUsers();

    User getById(long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}
