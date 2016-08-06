package com.stwitter.util;

import java.util.Date;

import org.joda.time.LocalDate;

import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;

/**
 * (c) Swissquote 8/5/16
 *
 * @author Shcherbina A.
 */
public class TestUtils {
	private static int hobbyCounter = 1;
	private static int personCounter = 1;

	private static Date TEST_DATE = LocalDate.now().toDate();

	public static Person getPerson() {
		Person p = new Person();
		p.setBirthday(TEST_DATE);
		p.setId(Long.valueOf(personCounter));
		p.setFirstName("Ivan");
		p.setLastName("Ivanenko");
		p.setLogin("ivan" + personCounter + "000");
		p.setEmail("email@em.com");
		p.setPassword("password123");
		personCounter++;
		return p;
	}

	public static Hobby getHobby() {
		Hobby h = new Hobby();
		h.setTitle("Title" + hobbyCounter);
		h.setDescription("Desc" + hobbyCounter);
		hobbyCounter++;
		return h;
	}

	public static Date getTestDate() {
		return TEST_DATE;
	}
}
