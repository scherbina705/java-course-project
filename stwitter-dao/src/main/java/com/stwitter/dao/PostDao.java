package com.stwitter.dao;

import com.stwitter.entity.Person;
import com.stwitter.entity.Post;

import java.util.Set;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
public interface PostDao extends GenericDao<Post, Long> {

    Set<Post> findLatestPosts(Integer postsNumber);

    Set<Post> findLatestPostsFromPerson(String personLogin, Integer postsNumber);

    Set<Post> findPostsFromPerson(Long personId);

    Set<Person> findPersonsLikedPost(Post post);

    void likePost(Post post, Person person);
}
