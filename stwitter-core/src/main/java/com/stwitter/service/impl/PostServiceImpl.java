package com.stwitter.service.impl;

import com.stwitter.dao.PersonDao;
import com.stwitter.dao.PostDao;
import com.stwitter.dto.PostDto;
import com.stwitter.entity.Post;
import com.stwitter.service.PostService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public LinkedList<PostDto> getLatestPostsForUser(String personLogin, int postsNumber) {
        Set<Post> posts = postDao.findLatestPostsFromPerson(personLogin, postsNumber);
        LinkedList<PostDto> sortedPostsDto = new LinkedList<>();
        for (Post p : posts) {
            sortedPostsDto.add(mapper.map(p, PostDto.class));
        }
        sortedPostsDto.sort((PostDto o1, PostDto o2) -> o1.getPlaceTime().compareTo(o2.getPlaceTime()));
        return sortedPostsDto;
    }

    @Override
    public int getAllLikesForPost(Long postId) {
        Post post = postDao.findById(postId);
        return postDao.findPersonsLikedPost(post).size();
    }


    @Override
    public LinkedList<PostDto> getLatestPosts(int postsNumber) {
        Set<Post> posts = postDao.findLatestPosts(postsNumber);
        LinkedList<PostDto> sortedPostsDto = new LinkedList<>();
        for (Post p : posts) {
            sortedPostsDto.add(mapper.map(p, PostDto.class));
        }
        sortedPostsDto.sort((PostDto o1, PostDto o2) -> o1.getPlaceTime().compareTo(o2.getPlaceTime()));
        return sortedPostsDto;
    }

    @Override
    public void likePost(Long postId, String personLogin) {
        postDao.likePost(postDao.findById(postId), personDao.findByLogin(personLogin));
    }
}
