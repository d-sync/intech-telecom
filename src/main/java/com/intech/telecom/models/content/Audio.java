package com.intech.telecom.models;

import javax.persistence.*;

@Entity
@Table(name = "audios")
public class Audio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "artsit")
	private String artist;

	@Column(name = "composition")
	private String composition;

	@Column(name = "isPopular")
	private boolean isPopular;

	@Column(name = "isNewest")
	private boolean isNewest;

	@Column(name = "isHit")
	private boolean isHit;

	public Audio() {
	}

	public Audio(String artist, String composition, boolean isPopular, boolean isNewest, boolean isHit) {
		this.artist = artist;
		this.composition = composition;
		this.isPopular = isPopular;
		this.isNewest = isNewest;
		this.isHit = isHit;
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

	public boolean isPopular() {
		return isPopular;
	}

	public void setPopular(boolean popular) {
		isPopular = popular;
	}

	public boolean isNewest() {
		return isNewest;
	}

	public void setNewest(boolean newest) {
		isNewest = newest;
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean hit) {
		isHit = hit;
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
