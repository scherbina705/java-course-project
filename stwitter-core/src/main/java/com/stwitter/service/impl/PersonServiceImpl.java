package com.stwitter.service.impl;


import org.dozer.DozerBeanMapper;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stwitter.dao.FriendshipDao;
import com.stwitter.dao.PersonDao;
import com.stwitter.dto.PersonDto;
import com.stwitter.entity.Friendship;
import com.stwitter.entity.Person;
import com.stwitter.service.PersonService;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;

	@Autowired
	private FriendshipDao friendshipDao;

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public void addFriendship(Long personId, Long friendId) {
		Person person = personDao.findById(personId);
		Person friend = personDao.findById(friendId);
		Friendship friendship = new Friendship();
		friendship.setFriend(friend);
		friendship.setPerson(person);
		friendship.setDateFrom(LocalDate.now().toDate());
		friendshipDao.save(friendship);
	}

	@Override
	public Long savePerson(PersonDto personDto) {
		return personDao.save(mapper.map(personDto, Person.class));
	}

	@Override
	public void removePerson(Long personId) {
		Person entity = personDao.findById(personId);
		personDao.delete(entity);
	}
}
