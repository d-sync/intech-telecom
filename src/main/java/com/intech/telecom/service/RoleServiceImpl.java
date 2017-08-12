package com.intech.telecom.service;


import com.intech.telecom.dao.RoleDao;
import com.intech.telecom.models.members.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public void addRole(Role role) {
        roleDao.persist(role);
    }
}
