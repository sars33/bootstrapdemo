package com.democrud.demo.dao;

import com.democrud.demo.model.User;

import java.util.List;

public interface UserDao {

    List<User> listAllUsers();

    User getById(long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}
