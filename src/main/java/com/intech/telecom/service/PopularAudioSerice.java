package com.intech.telecom.service;


import com.intech.telecom.models.content.PopularAudio;


public interface PopularAudioSerice {

	void add(PopularAudio audio);

	long getPopularAudioAmount();

	PopularAudio getPopularAudioByPid(Long pid);
}
