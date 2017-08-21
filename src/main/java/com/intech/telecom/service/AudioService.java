package com.intech.telecom.service;

import com.intech.telecom.models.content.Audio;

public interface AudioService {

	Audio getAudioById(Long id);

	Audio getNextAudioInAccount(String msisdn, Long id);
}
