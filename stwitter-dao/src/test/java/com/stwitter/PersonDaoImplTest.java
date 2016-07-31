package com.stwitter;

import com.stwitter.dao.PersonDao;
import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;
import org.joda.time.LocalDate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 31.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PersonDaoImplTest {

    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";
    public static final String LOGIN = "ivan4000";
    public static final Date BIRTHDAY = LocalDate.now().toDate();
    public static final Hobby hobby1 = new Hobby("title1", "desc1");
    public static final Hobby hobby2 = new Hobby("title2", "desc2");

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
//        testPerson.getHobbies().add(hobby1);
//        testPerson.getHobbies().add(hobby2);
    }

    @Test
    public void testSavePerson() {
        personDao.save(testPerson);
        assertThat(personDao.findAll(Person.class).size()).isEqualTo(1);
        Person savedPerson = personDao.findAll(Person.class).get(0);
        assertThat(savedPerson.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(savedPerson.getLastName()).isEqualTo(LAST_NAME);
        assertThat(savedPerson.getLogin()).isEqualTo(LOGIN);
//        assertThat(savedPerson.getHobbies().size()).isEqualTo(2);

//
//        Long hobbyId = hobbyDao.save(testHobby);
//
//        //THEN
//        assertThat(personDao.findAll(Person.class).size()).isEqualTo(1);
//        Person savedHobby = personDao.findAll(Person.class).get(0);
//        assertThat(savedHobby.getTitle()).isEqualTo(TITLE);
//        assertThat(savedHobby.getDescription()).isEqualTo(DESCRIPTION);
    }
}
