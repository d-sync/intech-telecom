package com.intech.telecom.models.content;

import javax.persistence.*;

@Entity
@Table(name = "popular_audio")
@PrimaryKeyJoinColumn(name = "audio_id")
public class PopularAudio extends Audio {

	@Column(name = "pid", nullable = false)
	private Long pid;

	public PopularAudio() {
		super();
	}

	public PopularAudio(String artist, String composition) {
		super(artist, composition);
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
}
