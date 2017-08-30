package com.intech.telecom.models.content;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "audios")
public class Audio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "artist")
	private String artist;

	@Column(name = "composition")
	private String composition;

	@Column(name = "isNew", nullable = false)
	private boolean isNew;

	@Column(name = "isPopular", nullable = false)
	private boolean isPopular;

	@Column(name = "isHit", nullable = false)
	private boolean isHit;

	public Audio() {
	}

	public Audio(String artist, String composition) {
		this.artist = artist;
		this.composition = composition;
	}

	public Audio(String artist, String composition, boolean isNew, boolean isPopular, boolean isHit) {
		this.artist = artist;
		this.composition = composition;
		this.isNew = isNew;
		this.isPopular = isPopular;
		this.isHit = isHit;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean aNew) {
		isNew = aNew;
	}

	public boolean isPopular() {
		return isPopular;
	}

	public void setPopular(boolean popular) {
		isPopular = popular;
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean hit) {
		isHit = hit;
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
