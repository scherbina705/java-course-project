package com.stwitter.dao.impl;

import com.stwitter.dao.PostDao;
import com.stwitter.entity.Post;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class PostDaoImpl extends AbstractDao implements PostDao {
    @Override
    public Post getPostById(Long postId) {
        Query query = getSession().createQuery("select p from Post p where p.id like :id").setLong("id", postId);
        return (Post) query.uniqueResult();
    }

    @Override
    public List<Post> getLatestPosts(Integer postsNumber) {
        return null;
    }

    @Override
    public List<Post> getPostsForPerson(Long personId) {
        return null;
    }

    @Override
    public Long savePost(Post post) {
        return (Long) getSession().save(post);
    }
}
