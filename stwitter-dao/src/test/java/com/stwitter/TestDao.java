package com.stwitter;

import com.stwitter.dao.HobbyDao;
import com.stwitter.entity.Hobby;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/persistence-context.xml")
public class TestDao {

    @Autowired
    private HobbyDao hobbyDao;

    public HobbyDao getHobbyDao() {
        return hobbyDao;
    }

    public void setHobbyDao(HobbyDao hobbyDao) {
        this.hobbyDao = hobbyDao;
    }

    @Test
    public void test1() {
        String hobbyTitle = "Title 1";
        Hobby hobby1 = new Hobby(hobbyTitle, "Descr 1");
        Long hobbyId = hobbyDao.saveHobby(hobby1);
        assertThat(hobbyDao.getHobbyById(hobbyId).getTitle()).isEqualTo(hobbyTitle);

//		personDao.getSession();
//		session.beginTransaction();
//		session.save(new Hobby("Title 1", "Descr 1"));
//		session.save(new Hobby("Title 2", "Descr 2"));
//		session.getTransaction().commit();
//		session.close();
//
//		// now lets pull Hobbies from the database and list them
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		List result = session.createQuery("from Hobby").list();
//		for (Hobby hobby : (List<Hobby>) result) {
//			System.out.println("Hobby (" + hobby.getTitle() + ") : " + hobby.getDescription());
//		}
//		session.getTransaction().commit();
//		session.close();
//		sessionFactory.close();
    }
}
