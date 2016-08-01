package com.stwitter.dao;

import com.stwitter.entity.Message;

import java.util.List;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface MessageDao extends GenericDao<Message, Long> {

    List<Message> findMessagesFromUser(Long personId);

    List<Message> findMessagesToUser(Long personId);
}
