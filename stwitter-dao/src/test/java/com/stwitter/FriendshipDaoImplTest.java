package com.stwitter;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.stwitter.dao.FriendshipDao;
import com.stwitter.entity.Friendship;
import com.stwitter.entity.Person;
import com.stwitter.util.TestUtils;

/**
 * (c) Swissquote 8/3/16
 *
 * @author Shcherbina A.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class FriendshipDaoImplTest extends TestAbstractDao {

	@Autowired
	private FriendshipDao friendshipDao;

	@Test
	@Transactional
	@Rollback(true)
	public void findFriendshipsForPersonTest(){
		//GIVEN
		Friendship f = new Friendship();
		Person p1 = TestUtils.getPerson();
		Person p2 = TestUtils.getPerson();
		getSession().save(p1);
		getSession().save(p2);
		f.setPerson(p1);
		f.setFriend(p2);
		getSession().save(f);

		//WHEN
		friendshipDao.findFriendshipsForPerson(p1);

		//THEN
		assertThat(friendshipDao.findAll().size()).isEqualTo(1);
		assertThat(friendshipDao.findAll().get(0).getPerson()).isEqualTo(p1);
		assertThat(friendshipDao.findAll().get(0).getFriend()).isEqualTo(p2);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void saveFriendshipTest(){
		//GIVEN
		Friendship f = new Friendship();
		Person p1 = TestUtils.getPerson();
		Person p2 = TestUtils.getPerson();
		getSession().save(p1);
		getSession().save(p2);
		f.setPerson(p1);
		f.setFriend(p2);

		//WHEN
		friendshipDao.save(f);

		//THEN
		assertThat(friendshipDao.findAll().size()).isEqualTo(1);
		assertThat(friendshipDao.findAll().get(0).getPerson()).isEqualTo(p1);
		assertThat(friendshipDao.findAll().get(0).getFriend()).isEqualTo(p2);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void findByIdTest(){
		//GIVEN
		Friendship f = new Friendship();
		Person p1 = TestUtils.getPerson();
		Person p2 = TestUtils.getPerson();
		Long personId = (Long)getSession().save(p1);
		Long friendId = (Long)getSession().save(p2);
		f.setPerson(p1);
		f.setFriend(p2);
		getSession().save(f);

		//WHEN
		friendshipDao.findById(Pair.of(personId,friendId));

		//THEN
		assertThat(friendshipDao.findAll().size()).isEqualTo(1);
		assertThat(friendshipDao.findAll().get(0).getPerson()).isEqualTo(p1);
		assertThat(friendshipDao.findAll().get(0).getFriend()).isEqualTo(p2);
	}
}
