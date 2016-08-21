package com.stwitter.converter;

import com.stwitter.dao.HobbyDao;
import com.stwitter.dto.PersonDto;
import com.stwitter.entity.Person;
import org.dozer.DozerConverter;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by A.Shcherbina
 * on 10.08.2016.
 */
@Component
public class PersonDtoConverter extends DozerConverter<Person, PersonDto> {

    @Autowired
    private HobbyDao hobbyDao;

    public PersonDtoConverter() {
        super(Person.class, PersonDto.class);
    }

    @Override
    public PersonDto convertTo(Person person, PersonDto personDto) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setLogin(person.getLogin());
        dto.setBirthday(new LocalDate(person.getBirthday()).toString());
        dto.setEmail(person.getEmail());
        dto.setPassword(person.getPassword());
        dto.setHobbiesId(new ArrayList<>(person.getHobbiesId()));
        dto.setAvatarName(person.getAvatarName());
        return dto;
    }

    @Override
    public Person convertFrom(PersonDto personDto, Person person) {
        Person entity = new Person();
        entity.setId(personDto.getId());
        entity.setFirstName(personDto.getFirstName());
        entity.setLastName(personDto.getLastName());
        entity.setLogin(personDto.getLogin());
        entity.setBirthday(LocalDate.parse(personDto.getBirthday()).toDate());
        entity.setEmail(personDto.getEmail());
        entity.setPassword(personDto.getPassword());
        if (personDto.getAvatarName()!=null) entity.setAvatarName(personDto.getAvatarName());
        if (!personDto.getHobbiesId().isEmpty()) {
            personDto.getHobbiesId().stream().forEach(hobbyId -> entity.getHobbies().add(hobbyDao.findById(hobbyId)));
        }
        return entity;
    }

}
