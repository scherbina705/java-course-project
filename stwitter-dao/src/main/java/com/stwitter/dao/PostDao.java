package com.stwitter.dao;

import com.stwitter.entity.Post;

import java.util.List;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface PostDao {
    Post getPostById(Long postId);

    List<Post> getLatestPosts(Integer postsNumber);

    List<Post> getPostsForPerson(Long personId);

    Long savePost(Post post);
}
