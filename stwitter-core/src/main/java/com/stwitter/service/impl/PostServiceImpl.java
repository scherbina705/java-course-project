package com.stwitter.service.impl;

import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PostDto;
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
    public List<PostDto> getLatestPosts(Integer postsNumber) {
        PostDto postDto1 = new PostDto();
        PersonDto personDto1 = new PersonDto();
        personDto1.setNickName("Tom Johns");
        postDto1.setAuthorPersonId(personDto1.getId());
        postDto1.setPostId(1L);
        postDto1.setPostContent("- Если дать человеку право на одно безнаказанное убийство в жизни, то наш мир станет идеальным.\n" +
                "- Но ты его, возможно, уже не увидишь.");
        postDto1.setCreationDateTime(LocalDateTime.now());

        PostDto postDto2 = new PostDto();
        PersonDto personDto2 = new PersonDto();
        personDto2.setNickName("Peter Jackson");
        postDto2.setAuthorPersonId(personDto2.getId());
        postDto2.setPostId(2L);
        postDto2.setPostContent("\"Сынок, бегом домой! Никуда твои друзья не денутся!\"- убеждали нас родители?\n" +
                "Прошло время и где же теперь друзья то?");
        postDto2.setCreationDateTime(LocalDateTime.now());

        return Arrays.asList(postDto1, postDto2);
    }
}
