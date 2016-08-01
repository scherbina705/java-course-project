package com.stwitter.dao.impl;

import com.stwitter.dao.GenericDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
@Component
@Transactional
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public T findById(PK id, Class<T> entityClass) {
        Query query = getSession().createQuery("select t from " + entityClass.getSimpleName() + " t where t.id like :id").setParameter("id", id);
        return (T) query.uniqueResult();

    }

    @Override
    public List<T> findAll(Class<T> entityClass) {
        Query query = getSession().createQuery("select t from " + entityClass.getSimpleName() + " t");
        return query.list();
    }

    @Override
    public PK save(T value) {
        return (PK) getSession().save(value);
    }

    @Override
    public void update(T value) {
        getSession().update(value);
    }

    @Override
    public void delete(T value) {
        getSession().delete(value);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
