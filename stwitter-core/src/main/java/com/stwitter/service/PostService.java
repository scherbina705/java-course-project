package com.stwitter.service;

import java.util.List;

import com.stwitter.dto.PostDto;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
public interface PostService {
	List<PostDto> getLatestPostsForUser(Long personId, int postNumber);

	int getAllLikesForPost();

	List<PostDto> getLatestPosts(int postsNumber);
}
