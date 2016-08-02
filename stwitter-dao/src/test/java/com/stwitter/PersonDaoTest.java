package com.stwitter;

import com.stwitter.dao.PersonDao;
import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;
import com.stwitter.factory.HobbyFactory;
import org.joda.time.LocalDate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 31.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PersonDaoTest {

    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";
    public static final String LOGIN = "ivan4000";
    public static final Date BIRTHDAY = LocalDate.now().toDate();

    public static final Hobby hobby1 = new Hobby("title1", "desc1");
    public static final Hobby hobby2 = new Hobby("title2", "desc2");
    private static final String EMAIL = "email@email.com";

    private static Person testPerson;

    @Autowired
    private PersonDao personDao;

    @BeforeClass
    public static void setUp() {
        testPerson = new Person();
        testPerson.setBirthday(BIRTHDAY);
        testPerson.setFirstName(FIRST_NAME);
        testPerson.setLastName(LAST_NAME);
        testPerson.setLogin(LOGIN);
        testPerson.setEmail(EMAIL);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testSavePersonWithHobbies() {
        //GIVEN
        testPerson.getHobbies().add(HobbyFactory.getHobby());
        testPerson.getHobbies().add(HobbyFactory.getHobby());

        //WHEN
        personDao.save(testPerson);

        //THEN
        assertThat(personDao.findAll(Person.class).size()).isEqualTo(1);
        Person savedPerson = personDao.findAll(Person.class).get(0);
        assertThat(savedPerson.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(savedPerson.getLastName()).isEqualTo(LAST_NAME);
        assertThat(savedPerson.getLogin()).isEqualTo(LOGIN);
        assertThat(savedPerson.getEmail()).isEqualTo(EMAIL);
        assertThat(savedPerson.getHobbies().size()).isEqualTo(2);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindPersonByLogin() {
        //GIVEN
        personDao.save(testPerson);

        //WHEN
        Person person = personDao.findByLogin(LOGIN);

        //THEN
        assertThat(person.getLogin()).isEqualTo(LOGIN);
    }
}
