package com.stwitter.dao.impl;

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
public class PlaceDaoImpl extends AbstractDao implements PlaceDao {
    @Override
    public Place getPlaceById(Long placeId) {
        Query query = getSession().createQuery("select p from Place p where p.id like :id").setLong("id", placeId);
        return (Place) query.uniqueResult();
    }

    @Override
    public Place getPlaceForPost(Long postId) {
        Query query = getSession().createQuery("select p from Place p where p.post_id like :id").setLong("id", postId);
        return (Place) query.uniqueResult();
    }

    @Override
    public Long savePlace(Place place) {
        return (Long) getSession().save(place);
    }
}
