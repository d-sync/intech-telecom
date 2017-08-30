package com.intech.telecom.dao;

import com.intech.telecom.models.content.Audio;

public interface AudioDao extends GenericDao<Long, Audio> {

	Audio getNextAudioInAccount(String msisdn, Long id);

	Audio getNextPopularAudio(Long id);

	Audio getNextHitsAudio(Long id);

	Audio getNexNewesttAudio(Long id);
}
