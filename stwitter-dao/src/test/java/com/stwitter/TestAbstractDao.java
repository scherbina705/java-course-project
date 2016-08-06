package com.stwitter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

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
}
