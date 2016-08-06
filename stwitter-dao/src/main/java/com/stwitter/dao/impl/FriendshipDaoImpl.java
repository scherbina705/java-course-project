package com.stwitter.dao.impl;

import com.stwitter.dao.FriendshipDao;
import com.stwitter.entity.Friendship;
import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * (c) Swissquote 8/3/16
 *
 * @author Shcherbina A.
 */
@Component
@Transactional
public class FriendshipDaoImpl extends AbstractDao<Friendship, Pair<Long, Long>> implements FriendshipDao {

    @Autowired
    protected SessionFactory sessionFactory;


    @Override
    public List<Friendship> findAll() {
        return findAll(Friendship.class);
    }

    @Override
    public Pair<Long, Long> save(Friendship value) {
        Friendship savedFriendship = (Friendship) getSession().save(value);
        Long personId = savedFriendship.getPerson().getId();
        Long friendId = savedFriendship.getFriend().getId();
        return Pair.of(personId, friendId);
    }

    @Override
    public Friendship findById(Pair<Long, Long> id) {
        Query query = getSession().createQuery("select f from Friendship f where f.person.id=:person and f.friend.id=:friend")
                .setParameter("person", id.getKey()).setParameter("friend", id.getValue());
        return (Friendship) query.uniqueResult();
    }

    @Override
    public Set<Friendship> findFriendshipsForPerson(Long personId) {
        Query query = getSession().createQuery("select f from Friendship f where f.person.id=:person").setLong("person", personId);
        return new HashSet<>(query.list());
    }

}
