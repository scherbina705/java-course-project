package com.stwitter.dao;

import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;
import com.stwitter.entity.Place;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
@Transactional
public interface PersonDao extends GenericDao<Person, Long> {
    Person findByLogin(String login);

    Set<Person> findByHobby(Hobby h);

    Set<Person> findByPlace(Place p);
}
