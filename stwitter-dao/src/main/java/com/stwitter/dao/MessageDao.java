package com.stwitter.dao;

import com.stwitter.entity.Message;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface MessageDao extends GenericDao<Message, Long> {

    Message getMessagesFromUser(Long personId);

    Message getMessagesToUser(Long personId);
}
