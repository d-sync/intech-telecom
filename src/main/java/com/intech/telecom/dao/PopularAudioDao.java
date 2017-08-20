package com.intech.telecom.dao;

import com.intech.telecom.models.content.PopularAudio;

public interface PopularAudioDao extends GenericDao<Long, PopularAudio> {

	long getPopularAudioAmount();

	PopularAudio getByPid(long pid);


}
