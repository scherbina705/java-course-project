package com.stwitter.dao;

import com.stwitter.entity.Post;

import java.util.List;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface PostDao extends GenericDao<Post, Long> {

    List<Post> findLatestPosts(Integer postsNumber);

    List<Post> findPostsFromPerson(Long personId);

}
