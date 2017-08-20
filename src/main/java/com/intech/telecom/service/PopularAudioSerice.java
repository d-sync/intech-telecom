package com.intech.telecom.service;


import com.intech.telecom.models.content.PopularAudio;

import java.util.List;

public interface PopularAudioSerice {

	void add(PopularAudio audio);

	long getPopularAudioAmount();

	List<PopularAudio> getPopularAudio();

	PopularAudio getPopularAudioByPid(Long pid);
}
