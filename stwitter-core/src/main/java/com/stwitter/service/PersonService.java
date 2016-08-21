package com.stwitter.service;

import com.stwitter.dto.PersonDto;

import java.util.List;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
public interface PersonService {
    Long savePerson(PersonDto person);

    void removePerson(String personLogin);

    void addFriendship(String personLogin, String friendLogin);

    boolean isLoginAvailable(String login);
    List<PersonDto> getAllPersons();
}
