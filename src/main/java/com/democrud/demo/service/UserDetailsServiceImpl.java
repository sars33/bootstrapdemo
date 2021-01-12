package com.democrud.demo.service;

import com.democrud.demo.dao.UserDao;
import com.democrud.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public User loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.getUserByName(login);
        return user;
    }
}