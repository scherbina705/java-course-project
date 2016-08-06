package stwitter.util;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import com.stwitter.dto.HobbyDto;
import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PostDto;
import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;
import com.stwitter.entity.Post;

/**
 * (c) Swissquote 8/5/16
 *
 * @author Shcherbina A.
 */
public class TestUtils {
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
		p.setId(1L);
		return p;
	}

	public static Hobby getHobby() {
		Hobby h = new Hobby();
		h.setTitle("Title");
		h.setDescription("Desc");
		h.setId(1L);
		return h;
	}

	public static Post getPost() {
		Post p = new Post();
		p.setTitle("Title");
		p.setContent("Content");
		p.setPerson(getPerson());
		p.setPlaceTime(TEST_DATE_TIME.toDate());
		p.setId(1L);
		return p;
	}

	public static PersonDto getPersonDto() {
		PersonDto p = new PersonDto();
		p.setBirthday(TEST_DATE);
		p.setFirstName("Ivan");
		p.setLastName("Ivanenko");
		p.setLogin("ivan4000");
		p.setEmail("email@em.com");
		p.setId(1L);
		return p;
	}

	public static HobbyDto getHobbyDto() {
		HobbyDto h = new HobbyDto();
		h.setTitle("Title");
		h.setDescription("Desc");
		h.setId(1L);
		return h;
	}

	public static PostDto getPostDto() {
		PostDto p = new PostDto();
		p.setTitle("Title");
		p.setContent("Content");
		p.setPerson(getPersonDto());
		p.setPlaceTime(TEST_DATE_TIME);
		p.setId(1L);
		return p;
	}
}
