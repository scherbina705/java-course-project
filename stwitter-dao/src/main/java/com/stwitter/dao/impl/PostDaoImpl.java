package com.stwitter.dao.impl;

import com.stwitter.dao.PostDao;
import com.stwitter.entity.Person;
import com.stwitter.entity.Post;
import com.stwitter.entity.PostLikes;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Component
@Transactional
public class PostDaoImpl extends AbstractDao<Post, Long> implements PostDao {

    @Override
    public List<Post> findAll() {
        return findAll(Post.class);
    }

    @Override
    public void likePost(Post post, Person person) {
        getSession().save(new PostLikes(person, post));
    }

    @Override
    public Post findById(Long id) {
        return findById(id, Post.class);
    }

    @Override
    public Set<Post> findLatestPosts(Integer postsNumber) {
        Query query = getSession().createQuery("select p from Post p order by p.placeTime desc").setMaxResults(postsNumber);
        return new HashSet<>(query.list());
    }

    @Override
    public Set<Post> findPostsFromPerson(Long personId) {
        Query query = getSession().createQuery("select p from Post p where p.person = :id").setLong("id", personId);
        return new HashSet<>(query.list());
    }

    @Override
    public Set<Person> findPersonsLikedPost(Post post) {
        Query query = getSession().createQuery("select p.person from PostLikes p where p.post = :post").setParameter("post", post);
        return new HashSet<>(query.list());
    }

    @Override
    public Set<Post> findLatestPostsFromPerson(String personLogin, Integer postsNumber) {
        Query query = getSession().createQuery("select p from Post p where p.person.login=:personLogin order by p.placeTime desc").setParameter("personLogin", personLogin).setMaxResults(postsNumber);
        return new HashSet<>(query.list());
    }

    @Override
    public void deleteAll(Post... values) {
        for (Post post : values) {
            Query query = getSession().createQuery("delete PostLikes p where p.post = :post").setParameter("post", post);
            query.executeUpdate();
        }
        super.deleteAll(values);
    }

    @Override
    public void deleteCollection(Collection<Post> values) {
        for (Post post : values) {
            deleteAll(post);
        }
    }
}
