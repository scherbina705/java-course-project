package com.stwitter.dao.impl;

import com.stwitter.dao.MessageDao;
import com.stwitter.entity.Message;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class MessageDaoImpl extends AbstractDao implements MessageDao {
    @Override
    public Long saveMessage(Message message) {
        return (Long) getSession().save(message);
    }

    @Override
    public Message getMessageById(Long messageId) {
        Query query = getSession().createQuery("select m from Message m where m.id like :id").setLong("id", messageId);
        return (Message) query.uniqueResult();
    }

    @Override
    public Message getMessagesFromUser(Long personId) {
        Query query = getSession().createQuery("select m from Message m where m.personFrom like :id").setLong("id", personId);
        return (Message) query.uniqueResult();
    }

    @Override
    public Message getMessagesToUser(Long personId) {
        Query query = getSession().createQuery("select m from Message m where m.personTo like :id").setLong("id", personId);
        return (Message) query.uniqueResult();
    }
}
