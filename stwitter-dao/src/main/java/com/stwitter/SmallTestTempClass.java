package com.stwitter;

import com.stwitter.entity.Hobby;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
public class SmallTestTempClass {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("persistence-context.xml");
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Hobby("Title 1", "Descr 1"));
        session.save(new Hobby("Title 2", "Descr 2"));
        session.getTransaction().commit();
        session.close();

        // now lets pull Hobbys from the database and list them
        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Hobby").list();
        for (Hobby hobby : (List<Hobby>) result) {
            System.out.println("Hobby (" + hobby.getTitle() + ") : " + hobby.getDescription());
        }
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
