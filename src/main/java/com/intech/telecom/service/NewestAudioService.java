package com.intech.telecom.service;

import com.intech.telecom.models.content.NewestAudio;


public interface NewestAudioService {

	void add(NewestAudio audio);

	long getNewestAudioAmount();

	NewestAudio getNewestAudioByPid(Long pid);
}
