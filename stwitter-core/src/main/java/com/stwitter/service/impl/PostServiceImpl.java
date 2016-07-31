package com.stwitter.service.impl;

import com.stwitter.dto.Post;
import com.stwitter.dto.User;
import com.stwitter.service.PostService;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
@Service
public class PostServiceImpl implements PostService {
    @Override
    public void getLatestPostsForUser() {

    }

    @Override
    public void getAllLikesForPost() {

    }

    @Override
    //	mock
    public List<Post> getLatestPosts(Integer postsNumber) {
        Post post1 = new Post();
        User user1 = new User();
        user1.setNickName("Tom Johns");
        post1.setAuthor(user1);
        post1.setPostId(1L);
        post1.setPostText("- Если дать человеку право на одно безнаказанное убийство в жизни, то наш мир станет идеальным.\n" +
                "- Но ты его, возможно, уже не увидишь.");
        post1.setCreationDateTime(LocalDateTime.now().toDate().getTime());

        Post post2 = new Post();
        User user2 = new User();
        user2.setNickName("Peter Jackson");
        post2.setAuthor(user2);
        post2.setPostId(2L);
        post2.setPostText("\"Сынок, бегом домой! Никуда твои друзья не денутся!\"- убеждали нас родители?\n" +
                "Прошло время и где же теперь друзья то?");
        post2.setCreationDateTime(LocalDateTime.now().toDate().getTime());

        return Arrays.asList(post1, post2);
    }
}
