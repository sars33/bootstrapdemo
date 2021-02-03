package com.democrud.demo.dao;

import com.democrud.demo.model.User;
import com.democrud.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepo;

    @Override
    public List listAllUsers() {
        return userRepo.findAll();

    }

    @Override
    public User getById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }
}

