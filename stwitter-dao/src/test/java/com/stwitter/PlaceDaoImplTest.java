package com.stwitter;

import com.stwitter.dao.PlaceDao;
import com.stwitter.entity.Person;
import com.stwitter.entity.Place;
import com.stwitter.util.TestUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 02.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PlaceDaoImplTest extends TestAbstractDao {

    @Autowired
    private PlaceDao placeDao;

    @Test
    @Transactional
    @Rollback(true)
    public void findPlaceForPostTest() {
        //GIVEN
        Person person = TestUtils.getPerson();
        getSession().save(person);

        Place place1 = new Place();
        place1.setPerson(person);
        place1.setTitle("adas");
        place1.setDescription("adas");
        place1.setLatitude(12.34F);
        place1.setLongtitude(12.34F);

        placeDao.save(place1);

        //WHEN
        Place foundPlace = placeDao.findPlaceForPerson(person.getId());

        //THEN
        assertThat(foundPlace.getPerson()).isEqualTo(person);
    }

}
