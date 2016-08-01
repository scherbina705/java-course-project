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
public class PostDaoImpl extends GenericDaoImpl<Post, Long> implements PostDao {

    @Override
    public List<Post> getLatestPosts(Integer postsNumber) {
        Query query = getSession().createQuery("select p from Post p order by p.placeTime desc").setMaxResults(postsNumber);
        return query.list();
    }

    @Override
    public List<Post> getPostsForPerson(Long personId) {
        Query query = getSession().createQuery("select p from Post p where p.person like :id").setLong("id", personId);
        return query.list();
    }

}
