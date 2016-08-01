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
public class MessageDaoImpl extends GenericDaoImpl<Message, Long> implements MessageDao {

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
