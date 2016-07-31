package com.stwitter.dao;

import com.stwitter.entity.Place;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface PlaceDao {
    Place getPlaceById(Long placeId);

    Place getPlaceForPost(Long postId);

    Long savePlace(Place place);
}
