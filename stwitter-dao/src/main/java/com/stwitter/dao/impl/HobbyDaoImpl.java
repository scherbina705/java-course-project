package com.stwitter.dao.impl;

import com.stwitter.dao.HobbyDao;
import com.stwitter.entity.Hobby;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class HobbyDaoImpl extends AbstractDao<Hobby, Long> implements HobbyDao {

    @Override
    public Hobby findById(Long id) {
        return findById(id, Hobby.class);
    }

    @Override
    public List<Hobby> findAll() {
        return findAll(Hobby.class);
    }

    @Override
    public Hobby findHobbyByTitle(String title) {
        Query query = getSession().createQuery("select h from Hobby h where h.title=:title").setString("title", title);
        return (Hobby) query.uniqueResult();
    }
}
