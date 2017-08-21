package com.intech.telecom.service;

import com.intech.telecom.models.content.Audio;
import com.intech.telecom.models.members.User;

public interface UserService {

    User getUserByUsername(String username);

    void addUser(User user);

	Audio buyAudioById(String msisdn, Long id);

	Audio deleteAudioFromAccount(String msisdn, Long id);
}
