package com.stwitter;

import com.stwitter.dao.MessageDao;
import com.stwitter.dao.PersonDao;
import com.stwitter.entity.Message;
import com.stwitter.entity.Person;
import com.stwitter.factory.PersonFactory;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 01.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class MessageDaoTest {
    @Autowired
    private PersonDao personDao;

    @Autowired
    private MessageDao messageDao;

    @Test
    @Transactional
    @Rollback(true)
    public void testFindMessageFromUser() {
        //GIVEN
        Person personTo = PersonFactory.getPerson();
        Person personFrom = PersonFactory.getPerson();
        personDao.save(personTo);
        personDao.save(personFrom);
        Message message = new Message();
        message.setContent("abc1");
        message.setPersonTo(personTo);
        message.setPersonFrom(personFrom);
        message.setTimeSent(LocalDateTime.now().toDate());

        Message message2 = new Message();
        message2.setContent("abc1");
        message2.setPersonTo(personTo);
        message2.setPersonFrom(personFrom);
        message2.setTimeSent(LocalDateTime.now().toDate());

        //WHEN
        messageDao.save(message);
        messageDao.save(message2);

        //THEN
        List<Message> foundMessages = messageDao.findMessagesFromUser(personFrom.getId());
        assertThat(foundMessages.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindMessageToUser() {
        //GIVEN
        Person personTo = PersonFactory.getPerson();
        Person personFrom = PersonFactory.getPerson();
        personDao.save(personTo);
        personDao.save(personFrom);
        Message message = new Message();
        message.setContent("abc1");
        message.setPersonTo(personTo);
        message.setPersonFrom(personFrom);
        message.setTimeSent(LocalDateTime.now().toDate());

        Message message2 = new Message();
        message2.setContent("abc1");
        message2.setPersonTo(personTo);
        message2.setPersonFrom(personFrom);
        message2.setTimeSent(LocalDateTime.now().toDate());

        //WHEN
        messageDao.save(message);
        messageDao.save(message2);

        //THEN
        List<Message> foundMessages = messageDao.findMessagesToUser(personTo.getId());
        assertThat(foundMessages.size()).isEqualTo(2);
    }
}
