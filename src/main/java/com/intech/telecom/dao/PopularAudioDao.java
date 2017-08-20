package com.intech.telecom.dao;

import com.intech.telecom.models.content.PopularAudio;

import java.util.List;

public interface PopularAudioDao extends GenericDao<Long, PopularAudio> {

	PopularAudio getPopularAudioById(Long id);

	long getPopularAudioAmount();

	List<PopularAudio> getPopularAudio();

}
