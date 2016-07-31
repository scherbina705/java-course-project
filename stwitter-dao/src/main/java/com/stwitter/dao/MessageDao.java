package com.stwitter.dao;

import com.stwitter.entity.Message;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface MessageDao {
    Long saveMessage(Message message);

    Message getMessageById(Long messageId);

    Message getMessagesFromUser(Long personId);

    Message getMessagesToUser(Long personId);
}
