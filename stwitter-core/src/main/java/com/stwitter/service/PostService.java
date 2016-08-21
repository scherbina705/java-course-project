package com.stwitter.service;

import com.stwitter.dto.PostDto;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
public interface PostService {
    List<PostDto> getLatestPostsForUser(String personLogin, int postsNumber);

    int getAllLikesForPost(Long postId);

    LinkedList<PostDto> getLatestPosts(int postsNumber);

    void likePost(Long postId, String personLogin);
}
