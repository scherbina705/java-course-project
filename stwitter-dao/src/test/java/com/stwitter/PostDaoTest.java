package com.stwitter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dao.PostDao;
import com.stwitter.entity.Person;
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

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 02.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PostDaoTest {
    private static int counter = 1;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PostDao postDao;


    @Test
    @Transactional
    @Rollback(true)
    public void findLatestPostsTest() {
        //GIVEN
        int expectedPostNumber = 7;
        for (int i = 0; i <= expectedPostNumber + 1; i++) {
            postDao.save(getPost());
        }

        //WHEN
        List<Post> posts = postDao.findLatestPosts(expectedPostNumber);

        //THEN
        assertThat(posts.size()).isEqualTo(expectedPostNumber);
        assertThat(posts).isSortedAccordingTo(new Comparator<Post>() {
            @Override
            public int compare(Post p1, Post p2) {
                return p2.getPlaceTime().compareTo(p1.getPlaceTime());
            }
        });
    }

    @Test
    @Transactional
    @Rollback(true)
    public void findPostsFromPersonTest() {
        //GIVEN
        postDao.save(getPost());
        postDao.save(getPost());

        //WHEN
        Person p = postDao.findAll(Post.class).get(0).getPerson();
        List<Post> posts = postDao.findPostsFromPerson(p.getId());

        //THEN
        assertThat(posts.size()).isEqualTo(1);
    }

    private Post getPost() {
        Post p = new Post();
        p.setContent("content" + counter);
        Person person = PersonFactory.getPerson();
        personDao.save(person);
        p.setPerson(person);
        p.setPlaceTime(LocalDateTime.now().toDate());
        p.setTitle("title" + counter);
        counter++;
        return p;
    }
}
