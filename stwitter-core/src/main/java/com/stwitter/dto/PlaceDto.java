package com.stwitter.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * (c) Swissquote 8/2/16
 *
 * @author Shcherbina A.
 */
public class PlaceDto {
	private Long id;
	private String title;
	private String description;
	private Float latitude;
	private Float longtitude;
	private PersonDto person;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Float longtitude) {
		this.longtitude = longtitude;
	}

	public PersonDto getPerson() {
		return person;
	}

	public void setPerson(PersonDto person) {
		this.person = person;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		PlaceDto placeDto = (PlaceDto) o;

		return new EqualsBuilder()
				.append(id, placeDto.id)
				.append(title, placeDto.title)
				.append(description, placeDto.description)
				.append(latitude, placeDto.latitude)
				.append(longtitude, placeDto.longtitude)
				.append(person, placeDto.person)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(title)
				.append(description)
				.append(latitude)
				.append(longtitude)
				.append(person)
				.toHashCode();
	}
}
