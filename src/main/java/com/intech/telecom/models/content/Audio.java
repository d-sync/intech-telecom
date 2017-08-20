package com.intech.telecom.models.content;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "audios")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Audio implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "artist")
	private String artist;

	@Column(name = "composition")
	private String composition;

	public Audio() {
	}

	public Audio(String artist, String composition) {
		this.artist = artist;
		this.composition = composition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Audio audio = (Audio) o;

		if (artist != null ? !artist.equals(audio.artist) : audio.artist != null) return false;
		return composition != null ? composition.equals(audio.composition) : audio.composition == null;
	}

	@Override
	public int hashCode() {
		int result = artist != null ? artist.hashCode() : 0;
		result = 31 * result + (composition != null ? composition.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return artist + " - " + composition;
	}
}
