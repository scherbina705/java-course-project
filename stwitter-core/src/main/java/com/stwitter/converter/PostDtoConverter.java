package com.stwitter.converter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dao.PostDao;
import com.stwitter.dto.PostDto;
import com.stwitter.entity.Post;
import org.dozer.DozerConverter;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Северская on 13.08.2016.
 */
@Component
public class PostDtoConverter extends DozerConverter<Post, PostDto> {
    @Autowired
    private PersonDao personDao;

    @Autowired
    private PostDao postDao;

    public PostDtoConverter() {
        super(Post.class, PostDto.class);
    }

    @Override
    public PostDto convertTo(Post post, PostDto postDto) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setContent(post.getContent());
        dto.setTitle(post.getTitle());
        dto.setPlaceTime(new LocalDateTime(post.getPlaceTime()));
        dto.setContent(post.getContent());
        dto.setAuthorLogin(post.getPerson().getLogin());
        dto.setPostLikes(Long.valueOf(postDao.findPersonsLikedPost(post).size()));
        return dto;
    }

    @Override
    public Post convertFrom(PostDto postDto, Post post) {
        Post entity = new Post();
        entity.setId(postDto.getId());
        entity.setContent(postDto.getContent());
        entity.setTitle(postDto.getTitle());
        entity.setPlaceTime(postDto.getPlaceTime().toDate());
        entity.setContent(postDto.getContent());
        entity.setPerson(personDao.findByLogin(postDto.getAuthorLogin()));
        return entity;
    }
}
