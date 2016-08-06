package com.stwitter;

import com.stwitter.dao.HobbyDao;
import com.stwitter.entity.Hobby;
import com.stwitter.util.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class HobbyDaoImplTest {

    @Autowired
    private HobbyDao hobbyDao;

    public HobbyDao getHobbyDao() {
        return hobbyDao;
    }

    public void setHobbyDao(HobbyDao hobbyDao) {
        this.hobbyDao = hobbyDao;
    }

    @Test
    @Transactional
    @Rollback(true)
    public void saveHobbyTest() {
        //GIVEN
        Hobby testHobby1 = TestUtils.getHobby();

        //WHEN
        hobbyDao.save(testHobby1);

        //THEN
        assertThat(hobbyDao.findAll().size()).isEqualTo(1);
        Hobby savedHobby = hobbyDao.findAll().get(0);
        assertThat(savedHobby.getTitle()).isEqualTo(testHobby1.getTitle());
        assertThat(savedHobby.getDescription()).isEqualTo(testHobby1.getDescription());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void findAllHobbiesTest() {
        //GIVEN
        Hobby testHobby1 = TestUtils.getHobby();
        Hobby testHobby2 = TestUtils.getHobby();

        //WHEN
        hobbyDao.save(testHobby1);
        hobbyDao.save(testHobby2);

        //THEN
        assertThat(hobbyDao.findAll().size()).isEqualTo(2);
        Hobby savedHobby = hobbyDao.findAll().get(0);
        assertThat(savedHobby.getTitle()).isEqualTo(testHobby1.getTitle());
        assertThat(savedHobby.getDescription()).isEqualTo(testHobby1.getDescription());
        Hobby savedHobby2 = hobbyDao.findAll().get(1);
        assertThat(savedHobby2.getTitle()).isEqualTo(testHobby2.getTitle());
        assertThat(savedHobby2.getDescription()).isEqualTo(testHobby2.getDescription());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateHobbyTest() {
        //GIVEN
        String changedDescription = "Another Description";
        Hobby testHobby1 = TestUtils.getHobby();
        hobbyDao.save(testHobby1);

        //WHEN
        testHobby1.setDescription(changedDescription);
        hobbyDao.update(testHobby1);

        //THEN
        assertThat(hobbyDao.findAll().size()).isEqualTo(1);
        Hobby savedHobby = hobbyDao.findAll().get(0);
        assertThat(savedHobby.getTitle()).isEqualTo(testHobby1.getTitle());
        assertThat(savedHobby.getDescription()).isEqualTo(changedDescription);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteHobbyTest() {
        //GIVEN
        String changedDescription = "Another Description";
        Hobby testHobby1 = TestUtils.getHobby();
        hobbyDao.save(testHobby1);

        //WHEN
        hobbyDao.deleteAll(testHobby1);

        //THEN
        assertTrue(hobbyDao.findAll().isEmpty());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void findHobbyByTitleTest() {
        //GIVEN
        Hobby testHobby = TestUtils.getHobby();
        String hobbyTitle = testHobby.getTitle();
        hobbyDao.save(testHobby);

        //WHEN
        Hobby foundHobby = hobbyDao.findHobbyByTitle(hobbyTitle);

        //THEN
        assertThat(foundHobby).isEqualTo(testHobby);
    }

}
