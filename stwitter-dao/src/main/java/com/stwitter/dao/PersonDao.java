package com.stwitter.dao;

import com.stwitter.entity.Person;
import org.springframework.transaction.annotation.Transactional;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
@Transactional
public interface PersonDao {
    Person getPersonById(Long personId);

    Person getPersonByLogin(String login);

    Long savePerson(Person person);
}
