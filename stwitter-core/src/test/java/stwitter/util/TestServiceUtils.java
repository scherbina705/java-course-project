package stwitter.util;

import com.stwitter.dto.HobbyDto;
import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PostDto;
import com.stwitter.entity.*;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

/**
 * Created by A.Shcherbina
 * on 06.08.2016.
 */
public class TestServiceUtils {
    private static final LocalDate TEST_DATE = LocalDate.now();
    private static final LocalDateTime TEST_DATE_TIME = LocalDateTime.now();

    public static LocalDate getTestDate() {
        return TEST_DATE;
    }

    public static LocalDateTime getTestDateTime() {
        return TEST_DATE_TIME;
    }

    public static Person getPerson() {
        Person p = new Person();
        p.setBirthday(TEST_DATE.toDate());
        p.setFirstName("Ivan");
        p.setLastName("Ivanenko");
        p.setLogin("ivan4000");
        p.setEmail("email@em.com");
        return p;
    }

    public static Hobby getHobby() {
        Hobby h = new Hobby();
        h.setTitle("Title");
        h.setDescription("Desc");
        return h;
    }

    public static Post getPost() {
        Post p = new Post();
        p.setTitle("Title");
        p.setContent("Content");
        p.setPerson(getPerson());
        p.setPlaceTime(TEST_DATE_TIME.toDate());
        return p;
    }

    public static Place getPlace() {
        Place p = new Place();
        p.setTitle("Title");
        p.setDescription("Description");
        p.setLatitude(10.5F);
        p.setLongtitude(10.5F);
        return p;
    }

    public static Message getMessage() {
        Message m = new Message();
        m.setTimeSent(TEST_DATE_TIME.toDate());
        m.setContent("adsadasd");
        return m;
    }

    public static PersonDto getPersonDto() {
        PersonDto p = new PersonDto();
        p.setBirthday(TEST_DATE.toString());
        p.setFirstName("Ivan");
        p.setLastName("Ivanenko");
        p.setLogin("ivan4000");
        p.setEmail("email@em.com");
        return p;
    }

    public static HobbyDto getHobbyDto() {
        HobbyDto h = new HobbyDto();
        h.setTitle("Title");
        h.setDescription("Desc");
        return h;
    }

    public static PostDto getPostDto() {
        PostDto p = new PostDto();
        p.setTitle("Title");
        p.setContent("Content");
        p.setAuthorLogin(getPersonDto().getLogin());
        p.setPlaceTime(TEST_DATE_TIME);
        return p;
    }
}
