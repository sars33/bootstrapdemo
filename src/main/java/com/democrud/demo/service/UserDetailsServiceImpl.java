package com.democrud.demo.service;

import com.democrud.demo.dao.UserDao;
import com.democrud.demo.model.Role;
import com.democrud.demo.model.User;
import com.democrud.demo.repositories.RoleRepository;
import com.democrud.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepo.getUserByEmail(login);
        return user;
    }

    @Override
    @Transactional
    public Role getRole(String role) {
        return roleRepo.getUserByRole(role);
    }

    @Override
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }
}
