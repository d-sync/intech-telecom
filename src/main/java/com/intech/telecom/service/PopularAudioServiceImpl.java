package com.intech.telecom.service;

import com.intech.telecom.dao.PopularAudioDao;
import com.intech.telecom.models.content.PopularAudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopularAudioServiceImpl implements PopularAudioSerice {

	@Autowired
	private PopularAudioDao popularAudioDao;

	@Override
	public void add(PopularAudio audio) {
		audio.setPid(popularAudioDao.getPopularAudioAmount()+1);
		popularAudioDao.persist(audio);
	}

	@Override
	public long getPopularAudioAmount() {
		return popularAudioDao.getPopularAudioAmount();
	}

	@Override
	public PopularAudio getPopularAudioByPid(Long pid) {
		return popularAudioDao.getByPid(pid);
	}
}
