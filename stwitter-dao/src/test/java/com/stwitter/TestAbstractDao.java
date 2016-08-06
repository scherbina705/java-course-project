package com.stwitter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * (c) Swissquote 8/5/16
 *
 * @author Shcherbina A.
 */
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class TestAbstractDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected List findAll(Class entityClass) {
        Query query = getSession().createQuery("select t from " + entityClass.getSimpleName() + " t");
        return query.list();
    }
}
