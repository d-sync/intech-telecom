package com.intech.telecom.service;

import com.intech.telecom.dao.HitsAudioDao;
import com.intech.telecom.models.content.HitsAudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HitsAudioServiceImpl implements HitsAudioService {


	@Autowired
	private HitsAudioDao hitsAudioDao;

	@Override
	public void add(HitsAudio audio) {
		audio.setPid(hitsAudioDao.getHitsAudioAmount()+1);
		hitsAudioDao.persist(audio);
	}

	@Override
	public long getHitsAudioAmount() {
		return hitsAudioDao.getHitsAudioAmount();
	}

	@Override
	public HitsAudio getHitsAudioByPid(long pid) {
		return hitsAudioDao.getHitsAudioByPid(pid);
	}
}
