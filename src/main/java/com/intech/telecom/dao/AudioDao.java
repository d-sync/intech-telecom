package com.intech.telecom.dao;

import com.intech.telecom.models.content.Audio;

public interface AudioDao extends GenericDao<Long, Audio> {
	long getAudioAmount();

	Audio getNextAudioInAccount(String msisdn, Long id);
}
