package com.intech.telecom.service;

import com.intech.telecom.models.content.Audio;

import java.util.List;

public interface PopularAudioSerice {

	void add(Audio audio);

	Audio getPopularAudioById(Long id);

	Audio getAudioById(Long id);

	long getPopularAudioAmount();

	List<Audio> getPopularAudio();

}
