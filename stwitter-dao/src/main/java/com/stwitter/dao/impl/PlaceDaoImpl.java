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
public class PlaceDaoImpl extends GenericDaoImpl<Place, Long> implements PlaceDao {

    @Override
    public Place getPlaceForPost(Long postId) {
        Query query = getSession().createQuery("select p from Place p where p.post_id like :id").setLong("id", postId);
        return (Place) query.uniqueResult();
    }

}
