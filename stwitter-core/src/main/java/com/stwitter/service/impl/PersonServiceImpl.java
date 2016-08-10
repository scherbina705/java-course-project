package com.stwitter.service.impl;


import com.stwitter.dao.*;
import com.stwitter.dto.PersonDto;
import com.stwitter.entity.Friendship;
import com.stwitter.entity.Person;
import com.stwitter.service.PersonService;
import org.dozer.DozerBeanMapper;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private MessageDao messageDao;

    @Autowired
    private PlaceDao placeDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public Long savePerson(PersonDto personDto) {
        Person person = new Person();
        return personDao.save(mapper.map(personDto, Person.class));
    }

    @Override
    public void removePerson(String personLogin) {
        Person person = personDao.findByLogin(personLogin);
        //Done so, because for current table schema's size cheaper to remove entities one by one,
        // instead of putting bidirectional associations in Person entity detach related entities before remove action
        friendshipDao.deleteCollection(friendshipDao.findFriendshipsForPerson(person.getId()));
        messageDao.deleteCollection(messageDao.findMessagesFromUser(person.getId()));
        messageDao.deleteCollection(messageDao.findMessagesToUser(person.getId()));
        postDao.deleteCollection(postDao.findPostsFromPerson(person.getId()));
        placeDao.findPlaceForPerson(person).getPersons().remove(person);
        personDao.deleteAll(person);
    }

    @Override
    public void addFriendship(String personLogin, String friendLogin) {
        Person person = personDao.findByLogin(personLogin);
        Person friend = personDao.findByLogin(friendLogin);
        Friendship friendship = new Friendship();
        friendship.setFriend(friend);
        friendship.setPerson(person);
        friendship.setDateFrom(LocalDate.now().toDate());
        friendshipDao.save(friendship);
    }

}
