package com.stwitter;

import com.stwitter.dao.PersonDao;
import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;
import com.stwitter.entity.Place;
import com.stwitter.util.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 31.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PersonDaoImplTest extends TestAbstractDao {
    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanenko";
    private static final String EMAIL = "email@em.com";
    private static final String PASSWORD = "password123";

    @Autowired
    private PersonDao personDao;

    @Test
    @Transactional
    @Rollback(true)
    public void savePersonWithHobbiesTest() {
        //GIVEN
        Person person = TestUtils.getPerson();
        String personLogin = person.getLogin();
        person.getHobbies().add(TestUtils.getHobby());
        person.getHobbies().add(TestUtils.getHobby());

        //WHEN
        personDao.save(person);

        //THEN
        assertThat(personDao.findAll().size()).isEqualTo(1);
        Person savedPerson = personDao.findAll().get(0);
        assertThat(savedPerson.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(savedPerson.getLastName()).isEqualTo(LAST_NAME);
        assertThat(savedPerson.getLogin()).isEqualTo(personLogin);
        assertThat(savedPerson.getEmail()).isEqualTo(EMAIL);
        assertThat(savedPerson.getPassword()).isEqualTo(PASSWORD);
        assertThat(savedPerson.getBirthday()).isEqualTo(TestUtils.getTestDate());
        assertThat(savedPerson.getHobbies().size()).isEqualTo(2);
        List<Hobby> hobbies = new ArrayList<>(savedPerson.getHobbies());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void findPersonByLoginTest() {
        //GIVEN
        Person person = TestUtils.getPerson();
        String personLogin = person.getLogin();
        personDao.save(person);

        //WHEN
        Person foundPerson = personDao.findByLogin(personLogin);

        //THEN
        assertThat(foundPerson.getLogin()).isEqualTo(personLogin);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void findPersonsByHobbyTest() {
        //GIVEN
        Person person1 = TestUtils.getPerson();
        Person person2 = TestUtils.getPerson();
        Person person3 = TestUtils.getPerson();

        Hobby h = TestUtils.getHobby();
        person1.getHobbies().add(h);
        person2.getHobbies().add(h);
        person3.getHobbies().add(h);

        personDao.save(person1);
        personDao.save(person2);
        personDao.save(person3);


        //WHEN
        Set<Person> foundPersons = personDao.findByHobby(h);

        //THEN
        assertThat(foundPersons.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void findPersonsByPlaceTest() {
        //GIVEN
        Person person1 = TestUtils.getPerson();
        Person person2 = TestUtils.getPerson();
        Person person3 = TestUtils.getPerson();

        personDao.save(person1);
        personDao.save(person2);
        personDao.save(person3);

        Place place = new Place();
        place.getPersons().add(person1);
        place.getPersons().add(person2);
        place.getPersons().add(person3);
        getSession().save(place);

        //WHEN
        Set<Person> foundPersons = personDao.findByPlace(place);

        //THEN
        assertThat(foundPersons.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void hobbyPersistedAfterPersonsRemovalTest() {
        //GIVEN
        Person person = TestUtils.getPerson();
        person.getHobbies().add(TestUtils.getHobby());
        person.getHobbies().add(TestUtils.getHobby());
        getSession().save(person);

        //WHEN
        personDao.deleteAll(person);

        //THEN
        List<Person> foundPersons = personDao.findAll();
        List<Hobby> foundHobbies = findAll(Hobby.class);
        assertThat(foundPersons.size()).isEqualTo(0);
        assertThat(foundHobbies.size()).isEqualTo(2);
    }
}
