package com.stwitter.dto;

import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;

import java.util.Set;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
public class PersonDto {
    private String nickName;
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Set<HobbyDto> hobbies;

    public static PersonDto convertToDto(Person entity) {
        PersonDto p = new PersonDto();
        p.setLastName(entity.getLastName());
        p.setEmail(entity.getEmail());
        p.setFirstName(entity.getFirstName());
        for (Hobby hobby : entity.getHobbies()) {
            p.getHobbies().add(HobbyDto.convertToDto(hobby));
        }
        p.setNickName(entity.getLogin());
        p.setId(entity.getId());
        return p;
    }

    public static Person convertToEntity(PersonDto dto) {
        Person p = new Person();
        p.setLastName(dto.getLastName());
        p.setEmail(dto.getEmail());
        p.setFirstName(dto.getFirstName());
        for (HobbyDto hobby : dto.getHobbies()) {
            p.getHobbies().add(HobbyDto.convertToEntity(hobby));
        }
        p.setLogin(dto.getNickName());
        p.setId(dto.getId());
        return p;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<HobbyDto> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<HobbyDto> hobbies) {
        this.hobbies = hobbies;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDto personDto = (PersonDto) o;

        if (!nickName.equals(personDto.nickName)) return false;
        if (id != null ? !id.equals(personDto.id) : personDto.id != null) return false;
        if (!email.equals(personDto.email)) return false;
        if (!firstName.equals(personDto.firstName)) return false;
        if (!lastName.equals(personDto.lastName)) return false;
        return hobbies.equals(personDto.hobbies);

    }

    @Override
    public int hashCode() {
        int result = nickName.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + email.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + hobbies.hashCode();
        return result;
    }
}
