package com.intech.telecom.dao;



import com.intech.telecom.models.content.Audio;
import com.intech.telecom.models.members.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl  implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User geUserByUsername(String username) {
        return entityManager.createQuery("FROM User WHERE msisdn = :username", User.class).setParameter("username", username).getSingleResult();
    }

    @Override
    public boolean buyAudioById(String msisdn, Audio audio) {
        User user = geUserByUsername(msisdn);
        if (user.getAudios().contains(audio)) {
            return true;
        } {
            user.addAudio(audio);
            update(user);
            return false;
        }
    }

    @Override
    public void persist(User entity) {
        entityManager.persist(entity);
    }

    @Override
    public User getByKey(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void update(User group) {
        entityManager.merge(group);
    }

}
