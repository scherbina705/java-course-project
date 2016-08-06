package com.stwitter.dao;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.stwitter.entity.Friendship;
import com.stwitter.entity.Person;

/**
 * (c) Swissquote 8/3/16
 *
 * @author Shcherbina A.
 */
public interface FriendshipDao extends GenericDao<Friendship, Pair<Long, Long>>{

	List<Friendship> findFriendshipsForPerson(Person person);

}
