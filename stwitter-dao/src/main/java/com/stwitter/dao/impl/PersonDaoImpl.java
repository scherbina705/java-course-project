package com.stwitter.dao.impl;

import com.stwitter.dao.PersonDao;
import com.stwitter.entity.Person;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class PersonDaoImpl extends AbstractDao implements PersonDao {
    @Override
    public Person getPersonById(Long personId) {
        Query query = getSession().createQuery("select p from Person h where p.id like :id").setLong("id", personId);
        return (Person) query.uniqueResult();
    }

    @Override
    public Person getPersonByLogin(String login) {
        Query query = getSession().createQuery("select p from Person h where p.login like :login").setString("login", login);
        return (Person) query.uniqueResult();
    }

    @Override
    public Long savePerson(Person person) {
        return (Long) getSession().save(person);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
