package com.stwitter.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDateTime;

/**
 * (c) Swissquote 8/2/16
 *
 * @author Shcherbina A.
 */
public class MessageDto {
	private Long id;
	private String content;
	private LocalDateTime timeSent;
	private PersonDto personFrom;
	private PersonDto personTo;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PersonDto getPersonFrom() {
		return personFrom;
	}

	public void setPersonFrom(PersonDto personFrom) {
		this.personFrom = personFrom;
	}

	public PersonDto getPersonTo() {
		return personTo;
	}

	public void setPersonTo(PersonDto personTo) {
		this.personTo = personTo;
	}

	public LocalDateTime getTimeSent() {
		return timeSent;
	}

	public void setTimeSent(LocalDateTime timeSent) {
		this.timeSent = timeSent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		MessageDto that = (MessageDto) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(content, that.content)
				.append(timeSent, that.timeSent)
				.append(personFrom, that.personFrom)
				.append(personTo, that.personTo)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(content)
				.append(timeSent)
				.append(personFrom)
				.append(personTo)
				.toHashCode();
	}
}
