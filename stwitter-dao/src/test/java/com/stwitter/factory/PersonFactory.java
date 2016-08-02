package com.stwitter.factory;

import com.stwitter.entity.Person;
import org.joda.time.LocalDate;

/**
 * Created by A.Shcherbina
 * on 01.08.2016.
 */
public class PersonFactory {

    private static int counter = 1;

    public static Person getPerson() {
        Person p = new Person();
        p.setBirthday(LocalDate.now().toDate());
        p.setFirstName("Ivan" + counter);
        p.setLastName("Ivanenko" + counter);
        p.setLogin("ivan" + counter + "000");
        p.setEmail("email@em.com" + counter);
        counter++;
        return p;
    }
}
