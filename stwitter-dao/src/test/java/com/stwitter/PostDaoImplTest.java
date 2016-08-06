package com.stwitter;

import com.stwitter.dao.PostDao;
import com.stwitter.entity.Person;
import com.stwitter.entity.Post;
import com.stwitter.entity.PostLikes;
import com.stwitter.util.TestUtils;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 02.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PostDaoImplTest extends TestAbstractDao {
    private static int counter = 1;

    @Autowired
    private PostDao postDao;

    @Test
    @Transactional
    @Rollback(true)
    public void findLatestPostsTest() {
        //GIVEN
        Person person = TestUtils.getPerson();
        getSession().save(person);
        int expectedPostNumber = 7;
        for (int i = 0; i <= expectedPostNumber + 1; i++) {
            Post post = getPost();
            post.setPerson(person);
            getSession().save(post);
        }

        //WHEN
        Set<Post> posts = postDao.findLatestPostsFromPerson(person.getLogin(), expectedPostNumber);

        //THEN
        assertThat(posts.size()).isEqualTo(expectedPostNumber);
        for (Post p : posts) {
            assertThat(p.getPerson()).isEqualTo(person);
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void findLatestPostsFromPersonTest() {
        //GIVEN
        int expectedPostNumber = 7;
        for (int i = 0; i <= expectedPostNumber + 1; i++) {
            getSession().save(getPost());
        }

        //WHEN
        Set<Post> posts = postDao.findLatestPosts(expectedPostNumber);

        //THEN
        assertThat(posts.size()).isEqualTo(expectedPostNumber);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void findPostsFromPersonTest() {
        //GIVEN
        getSession().save(getPost());
        getSession().save(getPost());

        //WHEN
        Person p = postDao.findAll().get(0).getPerson();
        Set<Post> posts = postDao.findPostsFromPerson(p.getId());

        //THEN
        assertThat(posts.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void likePostTest() {
        //GIVEN
        Person person = TestUtils.getPerson();
        getSession().save(person);

        Post post = new Post();
        post.setContent("content");
        post.setPerson(person);
        post.setPlaceTime(LocalDateTime.now().toDate());
        post.setTitle("title");
        getSession().save(post);

        //WHEN
        postDao.likePost(post, person);

        //THEN
        PostLikes p = (PostLikes) getSession().createQuery("select p from PostLikes p").uniqueResult();
        assertThat(p.getPerson()).isEqualTo(person);
        assertThat(p.getPost()).isEqualTo(post);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void findPersonsLikedPostTest() {
        //GIVEN
        Person person1 = TestUtils.getPerson();
        Person person2 = TestUtils.getPerson();
        getSession().save(person1);
        getSession().save(person2);

        Post post = new Post();
        post.setContent("content");
        post.setPerson(person1);
        post.setPlaceTime(LocalDateTime.now().toDate());
        post.setTitle("title");
        getSession().save(post);

        PostLikes like1 = new PostLikes(person1, post);
        PostLikes like2 = new PostLikes(person2, post);
        getSession().save(like1);
        getSession().save(like2);

        //WHEN
        List<Post> posts = postDao.findAll();
        Set<Person> persons = postDao.findPersonsLikedPost(post);

        //THEN
        assertThat(persons.size()).isEqualTo(2);
        assertThat(persons).containsOnly(person1, person2);
    }


    private Post getPost() {
        Post p = new Post();
        p.setContent("content" + counter);
        Person person = TestUtils.getPerson();
        getSession().save(person);
        p.setPerson(person);
        p.setPlaceTime(LocalDateTime.now().toDate());
        p.setTitle("title" + counter);
        counter++;
        return p;
    }
}
