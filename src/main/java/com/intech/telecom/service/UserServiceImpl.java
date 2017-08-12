package com.intech.telecom.service;


import com.intech.telecom.dao.UserDao;
import com.intech.telecom.models.members.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.geUserByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userDao.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }
}
