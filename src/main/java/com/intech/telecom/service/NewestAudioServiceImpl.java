package com.intech.telecom.service;

import com.intech.telecom.dao.NewestAudioDao;
import com.intech.telecom.models.content.NewestAudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewestAudioServiceImpl implements NewestAudioService {

	@Autowired
	NewestAudioDao newestAudioDao;

	@Override
	public void add(NewestAudio audio) {
		audio.setPid(newestAudioDao.getNewestAudioAmount()+1);
		newestAudioDao.persist(audio);
	}

	@Override
	public long getNewestAudioAmount() {
		return newestAudioDao.getNewestAudioAmount();
	}

	@Override
	public NewestAudio getNewestAudioByPid(Long pid) {
		return newestAudioDao.getNewestAudioByPid(pid);
	}

}
