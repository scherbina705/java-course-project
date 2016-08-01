package com.stwitter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dao.PlaceDao;
import com.stwitter.dao.PostDao;
import com.stwitter.entity.Person;
import com.stwitter.entity.Place;
import com.stwitter.entity.Post;
import com.stwitter.factory.PersonFactory;
import org.joda.time.LocalDateTime;
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
public class PlaceDaoTest {
    @Autowired
    private PostDao postDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PlaceDao placeDao;

    @Test
    @Transactional
    @Rollback(true)
    public void findPlaceForPostTest() {
        //GIVEN
        Post post = new Post();
        post.setTitle("title");
        post.setContent("content");
        post.setPlaceTime(LocalDateTime.now().toDate());
        Person p = PersonFactory.getPerson();
        personDao.save(p);
        post.setPerson(p);
        postDao.save(post);

        Place place = new Place();
        place.setPost(post);
        place.setTitle("adas");
        place.setDescription("adas");
        place.setLatitude(12.34D);
        place.setLongtitude(12.34D);
        placeDao.save(place);

        //WHEN
        Place foundPlace = placeDao.findPlaceForPost(post.getId());

        //THEN
        assertThat(foundPlace.getPost()).isEqualTo(post);
    }
}
