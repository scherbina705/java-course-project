package com.stwitter.dao;

import com.stwitter.entity.Friendship;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Set;

/**
 * (c) Swissquote 8/3/16
 *
 * @author Shcherbina A.
 */
public interface FriendshipDao extends GenericDao<Friendship, Pair<Long, Long>> {

    Set<Friendship> findFriendshipsForPerson(Long personId);
}
