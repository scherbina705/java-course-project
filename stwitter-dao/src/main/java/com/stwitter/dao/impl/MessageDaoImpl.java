package com.stwitter.dao.impl;

import com.stwitter.dao.MessageDao;
import com.stwitter.entity.Message;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class MessageDaoImpl extends AbstractDao<Message, Long> implements MessageDao {

    @Override
    public Set<Message> findMessagesFromUser(Long personId) {
        Query query = getSession().createQuery("from Message m where m.personFrom.id = :personId").setParameter("personId", personId);
        return new HashSet<>(query.list());
    }

    @Override
    public Set<Message> findMessagesToUser(Long personId) {
        Query query = getSession().createQuery("from Message m where m.personTo.id = :personId").setParameter("personId", personId);
        return new HashSet<>(query.list());
    }

    @Override
    public Message findById(Long id) {
        return findById(id, Message.class);
    }

    @Override
    public List<Message> findAll() {
        return findAll(Message.class);
    }
}
