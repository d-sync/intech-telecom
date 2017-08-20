package com.intech.telecom.models.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "hits_audio")
@PrimaryKeyJoinColumn(name = "audio_id")
public class HitsAudio extends Audio {

	@Column(name = "pid", nullable = false)
	private Long pid;

	public HitsAudio() {
		super();
	}

	public HitsAudio(String artist, String composition) {
		super(artist, composition);
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
}
