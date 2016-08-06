package com.stwitter.dao;

import java.util.List;

import com.stwitter.entity.Hobby;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface HobbyDao extends GenericDao<Hobby, Long> {
	List<Hobby> findHobbyByTitle(String title);
}
