package com.stwitter;

import com.stwitter.dao.MessageDao;
import com.stwitter.entity.Message;
import com.stwitter.entity.Person;
import com.stwitter.util.TestUtils;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 01.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class MessageDaoImplTest extends TestAbstractDao {

    @Autowired
    private MessageDao messageDao;

    @Test
    @Transactional
    @Rollback(true)
    public void testFindMessageFromUser() {
        //GIVEN
        Person personTo = TestUtils.getPerson();
        Person personFrom = TestUtils.getPerson();
        getSession().save(personTo);
        getSession().save(personFrom);
        Message message = new Message();
        message.setContent("abc1");
        message.setPersonTo(personTo);
        message.setPersonFrom(personFrom);
        message.setTimeSent(LocalDateTime.now().toDate());

        Message message2 = new Message();
        message2.setContent("abc2");
        message2.setPersonTo(personTo);
        message2.setPersonFrom(personFrom);
        message2.setTimeSent(LocalDateTime.now().toDate());

        //WHEN
        messageDao.save(message);
        messageDao.save(message2);

        //THEN
        Set<Message> foundMessages = messageDao.findMessagesFromUser(personFrom.getId());
        assertThat(foundMessages.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindMessageToUser() {
        //GIVEN
        Person personTo = TestUtils.getPerson();
        Person personFrom = TestUtils.getPerson();
        getSession().save(personTo);
        getSession().save(personFrom);
        Message message = new Message();
        message.setContent("abc1");
        message.setPersonTo(personTo);
        message.setPersonFrom(personFrom);
        message.setTimeSent(LocalDateTime.now().toDate());

        Message message2 = new Message();
        message2.setContent("abc2");
        message2.setPersonTo(personTo);
        message2.setPersonFrom(personFrom);
        message2.setTimeSent(LocalDateTime.now().toDate());

        //WHEN
        messageDao.save(message);
        messageDao.save(message2);

        //THEN
        Set<Message> foundMessages = messageDao.findMessagesToUser(personTo.getId());
        assertThat(foundMessages.size()).isEqualTo(2);
    }
}
