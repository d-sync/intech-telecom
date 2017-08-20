package com.intech.telecom.service;

import com.intech.telecom.models.content.HitsAudio;

public interface HitsAudioService {

	void add(HitsAudio audio);

	long getHitsAudioAmount();

	HitsAudio getHitsAudioByPid(long pid);
}
