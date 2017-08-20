package com.intech.telecom.dao;

import com.intech.telecom.models.content.HitsAudio;
import com.intech.telecom.models.content.NewestAudio;

public interface HitsAudioDao extends GenericDao<Long, HitsAudio> {


	HitsAudio getHitsAudioByPid(Long pid);

	long getHitsAudioAmount();


}
