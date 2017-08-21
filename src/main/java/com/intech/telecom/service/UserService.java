package com.intech.telecom.service;



import com.intech.telecom.models.content.Audio;
import com.intech.telecom.models.members.User;

import java.util.List;


public interface UserService {
    User getUserByUsername(String username);
    void addUser(User user);
    List<User> getAllUsers();

	Audio buyAudioById(String msisdn, Long id);

	Audio deleteAudioFromAccount(String msisdn, Long id);
}
