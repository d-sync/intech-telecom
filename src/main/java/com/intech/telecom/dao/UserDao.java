package com.intech.telecom.dao;


import com.intech.telecom.models.content.Audio;
import com.intech.telecom.models.members.User;

public interface UserDao extends GenericDao<Long, User>{
    User geUserByUsername(String username);

	boolean buyAudioById(String msisdn, Audio audio);
}
