package stwitter.util;

import com.stwitter.dto.HobbyDto;
import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PostDto;
import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;
import com.stwitter.entity.Post;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

/**
 * (c) Swissquote 8/5/16
 *
 * @author Shcherbina A.
 */
public class TestConverterUtils {

    public static LocalDate getTestDate() {
        return TestServiceUtils.getTestDate();
    }

    public static LocalDateTime getTestDateTime() {
        return TestServiceUtils.getTestDateTime();
    }

    public static Person getPerson() {
        Person p = TestServiceUtils.getPerson();
        p.setId(1L);
        return p;
    }

    public static Hobby getHobby() {
        Hobby h = TestServiceUtils.getHobby();
        h.setId(1L);
        return h;
    }

    public static Post getPost() {
        Post p = TestServiceUtils.getPost();
        p.setId(1L);
        return p;
    }

    public static PersonDto getPersonDto() {
        PersonDto p = TestServiceUtils.getPersonDto();
        p.setId(1L);
        return p;
    }

    public static HobbyDto getHobbyDto() {
        HobbyDto h = TestServiceUtils.getHobbyDto();
        h.setId(1L);
        return h;
    }

    public static PostDto getPostDto() {
        PostDto p = TestServiceUtils.getPostDto();
        p.setId(1L);
        return p;
    }
}
