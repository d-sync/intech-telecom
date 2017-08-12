package com.intech.telecom.service;



import com.intech.telecom.models.members.User;

import java.util.List;


public interface UserService {
    User getUserByUsername(String username);
    void addUser(User user);
    List<User> getAllUsers();
}
