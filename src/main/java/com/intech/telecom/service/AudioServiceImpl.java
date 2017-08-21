package com.intech.telecom.service;

import com.intech.telecom.dao.AudioDao;
import com.intech.telecom.models.content.Audio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudioServiceImpl implements AudioService{

	@Autowired
	AudioDao audioDao;

	@Override
	public Audio getAudioById(Long id) {
		return audioDao.getByKey(id);
	}

	@Override
	public Audio getNextAudioInAccount(String msisdn, Long id) {
		Audio audio = audioDao.getNextAudioInAccount(msisdn, id);
		return audio;
	}
}
