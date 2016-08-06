package com.stwitter.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.stwitter.dao.PlaceDao;
import com.stwitter.entity.Place;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class PlaceDaoImpl extends AbstractDao<Place, Long> implements PlaceDao {

    @Override
    public Place findPlaceForPerson(Long personId) {
        Query query = getSession().createQuery("from Place p where p.person.id = :id").setLong("id", personId);
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
