package com.stwitter.dao.impl;

import com.stwitter.dao.PersonDao;
import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;
import com.stwitter.entity.Place;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class PersonDaoImpl extends AbstractDao<Person, Long> implements PersonDao {
    @Override
    public Person findByLogin(String login) {
        Query query = getSession().createQuery("select p from Person p where p.login=:login").setString("login", login);
        return (Person) query.uniqueResult();
    }

    @Override
    public Set<Person> findByHobby(Hobby h) {
        Query query = getSession().createQuery("select p from Person p where :hobby in elements(p.hobbies)").setParameter("hobby", h);
        return new HashSet<>(query.list());
    }

    @Override
    public void addHobby(Person p, Hobby h) {
        p.getHobbies().add(h);
        getSession().update(p);
    }

    @Override
    public Set<Person> findByPlace(Place p) {
        Query query = getSession().createQuery("select p.persons from Place p where p=:place").setParameter("place", p);
        return new HashSet<>(query.list());
    }

    @Override
    public Person findById(Long id) {
        return findById(id, Person.class);
    }

    @Override
    public List<Person> findAll() {
        return findAll(Person.class);
    }

    @Override
    public void deleteAll(Person... values) {
        for (Person person : values) {
            person.getHobbies().clear();
            super.deleteAll(person);
        }
    }
}
