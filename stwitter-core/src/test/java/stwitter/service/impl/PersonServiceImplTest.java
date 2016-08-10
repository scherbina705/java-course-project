package stwitter.service.impl;

import com.stwitter.dao.*;
import com.stwitter.dto.PersonDto;
import com.stwitter.entity.*;
import com.stwitter.service.PersonService;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import stwitter.util.TestServiceUtils;

import java.util.ArrayList;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class PersonServiceImplTest {
    @Autowired
    private PersonService personService;

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
    private HobbyDao hobbyDao;


    @Test
    @Transactional
    @Rollback(true)
    public void savePersonTest() {
        //GIVEN
        PersonDto personDto = TestServiceUtils.getPersonDto();
        Hobby hobbyToSave = TestServiceUtils.getHobby();
        Long hobbyId = hobbyDao.save(hobbyToSave);
        personDto.getHobbiesId().add(hobbyId);

        //WHEN
        Long savedPersonId = personService.savePerson(personDto);

        //THEN
        Person savedPerson = personDao.findById(savedPersonId);
        assertThat(savedPerson.getId()).isNotNull();
        assertThat(savedPerson.getEmail()).isEqualTo(personDto.getEmail());
        assertThat(savedPerson.getBirthday()).isEqualTo(personDto.getBirthday().toDate());
        assertThat(savedPerson.getFirstName()).isEqualTo(personDto.getFirstName());
        assertThat(savedPerson.getLastName()).isEqualTo(personDto.getLastName());
        assertThat(savedPerson.getLogin()).isEqualTo(personDto.getLogin());
        assertThat(savedPerson.getPassword()).isEqualTo(personDto.getPassword());
        assertThat(savedPerson.getHobbies().size()).isEqualTo(1);
        Hobby hobby = new ArrayList<>(savedPerson.getHobbies()).get(0);
        assertThat(hobby.getId()).isNotNull();
        assertThat(hobby.getDescription()).isEqualTo(hobbyToSave.getDescription());
        assertThat(hobby.getTitle()).isEqualTo(hobbyToSave.getTitle());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void removePersonTest() {
        //GIVEN
        Person person = TestServiceUtils.getPerson();
        //add hobby
        Hobby hobby = TestServiceUtils.getHobby();
        person.getHobbies().add(hobby);
        personDao.save(person);
        //add post and like to it
        Post post = TestServiceUtils.getPost();
        post.setPerson(person);
        postDao.save(post);
        postDao.likePost(post, person);
        //add place
        Place place = TestServiceUtils.getPlace();
        place.getPersons().add(person);
        placeDao.save(place);
        //add messages
        Message messageTo = TestServiceUtils.getMessage();
        messageTo.setPersonTo(person);
        messageTo.setPersonFrom(person);

        Message messageFrom = TestServiceUtils.getMessage();
        messageFrom.setPersonTo(person);
        messageFrom.setPersonFrom(person);

        messageDao.save(messageFrom);
        messageDao.save(messageTo);

        //WHEN
        personService.removePerson(person.getLogin());
        //THEN
        assertThat(personDao.findAll().size()).isEqualTo(0);
        assertThat(hobbyDao.findAll().size()).isEqualTo(1);
        assertThat(postDao.findAll().size()).isEqualTo(0);
        assertThat(postDao.findPersonsLikedPost(post).size()).isEqualTo(0);
        assertThat(placeDao.findAll().size()).isEqualTo(1);
        assertThat(messageDao.findAll().size()).isEqualTo(0);
        assertThat(messageDao.findAll().size()).isEqualTo(0);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void addFriendshipTest() {
        //GIVEN
        Person person1 = TestServiceUtils.getPerson();
        Person person2 = TestServiceUtils.getPerson();
        person2.setLogin("ivan5000");
        personDao.save(person1);
        personDao.save(person2);

        //WHEN
        personService.addFriendship(person1.getLogin(), person2.getLogin());

        //THEN
        Set<Friendship> friendships = friendshipDao.findFriendshipsForPerson(person1.getId());
        assertThat(friendships.size()).isEqualTo(1);
        Friendship friendship = friendships.iterator().next();
        assertThat(friendship.getPerson()).isEqualTo(person1);
        assertThat(friendship.getFriend()).isEqualTo(person2);
        assertThat(friendship.getDateFrom().before(LocalDateTime.now().toDate())).isTrue();
    }
}
