package com.intech.telecom.dao;


import com.intech.telecom.models.members.User;

public interface UserDao extends GenericDao<Integer, User>{
    User geUserByUsername(String username);
}
