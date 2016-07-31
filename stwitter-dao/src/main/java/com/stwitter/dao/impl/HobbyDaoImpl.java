package com.stwitter.dao.impl;

import com.stwitter.dao.HobbyDao;
import com.stwitter.entity.Hobby;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class HobbyDaoImpl extends AbstractDao implements HobbyDao {
    @Override
    public Hobby getHobbyById(Long hobbyId) {
        Query query = getSession().createQuery("select h from Hobby h where h.id like :id").setLong("id", hobbyId);
        return (Hobby) query.uniqueResult();
    }

    @Override
    public Long saveHobby(Hobby hobby) {
        return (Long) getSession().save(hobby);
    }
}
