package com.intech.telecom.dao;

import com.intech.telecom.models.content.NewestAudio;

public interface NewestAudioDao extends GenericDao<Long, NewestAudio> {
	NewestAudio getNewestAudioByPid(Long pid);

	long getNewestAudioAmount();
}
