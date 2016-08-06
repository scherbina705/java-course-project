package com.stwitter.dao.impl;

import com.stwitter.dao.PlaceDao;
import com.stwitter.entity.Person;
import com.stwitter.entity.Place;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class PlaceDaoImpl extends AbstractDao<Place, Long> implements PlaceDao {

    @Override
    public Place findPlaceForPerson(Person person) {
        Query query = getSession().createQuery("from Place p where :person in elements(p.persons)").setParameter("person", person);
        return (Place) query.uniqueResult();
    }

    @Override
    public Place findById(Long id) {
        return findById(id, Place.class);
    }

    @Override
    public List<Place> findAll() {
        return findAll(Place.class);
    }
}
