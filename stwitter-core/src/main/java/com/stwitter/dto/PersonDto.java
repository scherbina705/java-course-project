package com.stwitter.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDate;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
public class PersonDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private String password;
	private LocalDate birthday;
	private Set<HobbyDto> hobbies = new HashSet<>();

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<HobbyDto> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<HobbyDto> hobbies) {
		this.hobbies = hobbies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		PersonDto personDto = (PersonDto) o;

		return new EqualsBuilder()
				.append(id, personDto.id)
				.append(firstName, personDto.firstName)
				.append(lastName, personDto.lastName)
				.append(email, personDto.email)
				.append(login, personDto.login)
				.append(password, personDto.password)
				.append(birthday, personDto.birthday)
				.append(hobbies, personDto.hobbies)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(firstName)
				.append(lastName)
				.append(email)
				.append(login)
				.append(password)
				.append(birthday)
				.append(hobbies)
				.toHashCode();
	}
}
