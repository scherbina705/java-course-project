package com.stwitter.dao;

import com.stwitter.entity.Person;
import org.springframework.transaction.annotation.Transactional;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
@Transactional
public interface PersonDao extends GenericDao<Person, Long> {

    Person findByLogin(String login);

}
