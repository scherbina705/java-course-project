package com.stwitter.service;

import com.stwitter.dto.PostDto;

import java.util.List;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
public interface PostService {
    void getLatestPostsForUser();

    void getAllLikesForPost();

    List<PostDto> getLatestPosts(Integer postsNumber);
}
