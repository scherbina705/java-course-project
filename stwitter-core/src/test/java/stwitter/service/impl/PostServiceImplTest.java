package stwitter.service.impl;

import com.stwitter.dao.*;
import com.stwitter.dto.PostDto;
import com.stwitter.entity.Person;
import com.stwitter.entity.Post;
import com.stwitter.service.PostService;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import stwitter.util.TestServiceUtils;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 06.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class PostServiceImplTest {
    @Autowired
    private PostService postService;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private FriendshipDao friendshipDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private PlaceDao placeDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private HobbyDao hobbyDao;


//    List<PostDto> getLatestPostsForUser(String personLogin, int postNumber);
//
//    int getAllLikesForPost(Long postId);
//
//    SortedSet<PostDto> getLatestPosts(int postsNumber);
//
//    void likePost(Long postId, String personLogin);

    @Test
    @Transactional
    @Rollback(true)
    public void getLatestPostsForUserTest() {
        //GIVEN
        int totalPostsNumber = 20;
        int expectedPostNumber = 10;
        Person person = TestServiceUtils.getPerson();
        personDao.save(person);
        for (int i = 0; i < totalPostsNumber; i++) {
            Post post = TestServiceUtils.getPost();
            post.setPlaceTime(LocalDateTime.now().plusMinutes(i).toDate());
            post.setPerson(person);
            postDao.save(post);
        }

        //WHEN
        LinkedList<PostDto> posts = postService.getLatestPostsForUser(person.getLogin(), expectedPostNumber);

        //THEN
        assertThat(posts.size()).isEqualTo(expectedPostNumber);
//        for (PostDto p : posts) {
//            assertThat(p.getPerson().getLogin()).isEqualTo(person.getLogin());
//        }
        assertThat(posts).isSortedAccordingTo((PostDto o1, PostDto o2) -> o1.getPlaceTime().compareTo(o2.getPlaceTime()));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void getLatestPostsTest() {
        //GIVEN
        int totalPostsNumber = 20;
        int expectedPostNumber = 10;
        Person person = TestServiceUtils.getPerson();
        personDao.save(person);
        for (int i = 0; i < totalPostsNumber; i++) {
            Post post = TestServiceUtils.getPost();
            post.setPlaceTime(LocalDateTime.now().plusMinutes(i).toDate());
            post.setPerson(person);
            postDao.save(post);
        }

        //WHEN
        LinkedList<PostDto> posts = postService.getLatestPosts(expectedPostNumber);

        //THEN
        assertThat(posts.size()).isEqualTo(expectedPostNumber);
        assertThat(posts).isSortedAccordingTo((PostDto o1, PostDto o2) -> o1.getPlaceTime().compareTo(o2.getPlaceTime()));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void getAllLikesForPostTest() {
        //GIVEN
        Person person1 = TestServiceUtils.getPerson();
        personDao.save(person1);
        Person person2 = TestServiceUtils.getPerson();
        person2.setLogin("login2");
        personDao.save(person2);
        Post post = TestServiceUtils.getPost();
        post.setPerson(person1);
        postDao.save(post);
        postDao.likePost(post, person1);
        postDao.likePost(post, person2);

        //WHEN
        int likes = postService.getAllLikesForPost(post.getId());

        //THEN
        assertThat(likes).isEqualTo(2);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void likePostTest() {
        //GIVEN
        Person person = TestServiceUtils.getPerson();
        personDao.save(person);
        Post post = TestServiceUtils.getPost();
        post.setPerson(person);
        postDao.save(post);

        //WHEN
        postService.likePost(post.getId(), person.getLogin());

        //THEN
        assertThat(postDao.findPersonsLikedPost(post).size()).isEqualTo(1);
    }
}
