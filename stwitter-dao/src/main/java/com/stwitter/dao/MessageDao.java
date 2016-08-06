package com.stwitter.dao;

import com.stwitter.entity.Message;

import java.util.Set;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface MessageDao extends GenericDao<Message, Long> {

    Set<Message> findMessagesFromUser(Long personId);

    Set<Message> findMessagesToUser(Long personId);
}
