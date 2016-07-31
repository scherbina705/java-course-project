package com.stwitter;

import com.stwitter.dao.HobbyDao;
import com.stwitter.entity.Hobby;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class HobbyDaoImplTest {
    public static final String TITLE = "Title 1";
    public static final String DESCRIPTION = "Descr 1";
    private Hobby testHobby;
    @Autowired
    private HobbyDao hobbyDao;

    @Before
    public void setUp() {
        testHobby = new Hobby();
        testHobby.setDescription(DESCRIPTION);
        testHobby.setTitle(TITLE);
    }

    public HobbyDao getHobbyDao() {
        return hobbyDao;
    }

    public void setHobbyDao(HobbyDao hobbyDao) {
        this.hobbyDao = hobbyDao;
    }

    @Test
    public void saveHobbyTest() {
        //WHEN
        hobbyDao.save(testHobby);

        //THEN
        assertThat(hobbyDao.findAll(Hobby.class).size()).isEqualTo(1);
        Hobby savedHobby = hobbyDao.findAll(Hobby.class).get(0);
        assertThat(savedHobby.getTitle()).isEqualTo(TITLE);
        assertThat(savedHobby.getDescription()).isEqualTo(DESCRIPTION);
    }
}
