package com.intech.telecom.dao;



import com.intech.telecom.models.members.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void persist(User entity) {
        entityManager.persist(entity);
    }

    @Override
    public User getByKey(Integer id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User group) {

    }

    @Override
    public void deleteByKey(Integer id) {

    }

    @Override
    public User geUserByUsername(String username) {
        return ((User) entityManager.createQuery("From User where username = :username").setParameter("username", username).getSingleResult());
    }
}
