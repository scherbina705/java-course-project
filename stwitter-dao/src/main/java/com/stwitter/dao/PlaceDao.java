package com.stwitter.dao;

import com.stwitter.entity.Place;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface PlaceDao extends GenericDao<Place, Long> {

    Place getPlaceForPost(Long postId);
}
