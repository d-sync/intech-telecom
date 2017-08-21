package com.intech.telecom.service;


import com.intech.telecom.dao.UserDao;
import com.intech.telecom.models.content.Audio;
import com.intech.telecom.models.members.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    AudioService audioService;

    @Override
    public User getUserByUsername(String username) {
        return userDao.geUserByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userDao.persist(user);
    }

    @Override
    public Audio buyAudioById(String msisdn, Long id) {
        Audio audio = audioService.getAudioById(id);
        boolean isAudioAlreadyPurchased = userDao.buyAudioById(msisdn, audio);
        if (isAudioAlreadyPurchased) audio = null;
        return audio;
    }

    @Override
    public Audio deleteAudioFromAccount(String msisdn, Long id) {
        Audio audio = audioService.getAudioById(id);
        User user = userDao.geUserByUsername(msisdn);
        user.getAudios().remove(audio);
        userDao.update(user);
        return audio;
    }
}
