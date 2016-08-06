package com.stwitter.dao.impl;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.stwitter.dao.FriendshipDao;
import com.stwitter.entity.Friendship;
import com.stwitter.entity.Person;

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
	public List<Friendship> findFriendshipsForPerson(Person person) {
		Query query = getSession().createQuery("select f from Friendship f where f.person=:person").setParameter("person", person);
		return query.list();
	}

}
