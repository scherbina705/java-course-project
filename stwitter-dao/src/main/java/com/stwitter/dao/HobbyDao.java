package com.stwitter.dao;

import com.stwitter.entity.Hobby;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface HobbyDao {
    Hobby getHobbyById(Long hobbyId);

    Long saveHobby(Hobby hobby);
}
