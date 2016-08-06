package com.stwitter.service.impl;

import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PostDto;
import com.stwitter.service.PostService;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
@Service
public class PostServiceImpl implements PostService {
	@Override
	public int getAllLikesForPost() {
		return 0;
	}

	@Override
	public List<PostDto> getLatestPostsForUser(Long personId, int postNumber) {
		return null;
	}

	@Override
	public List<PostDto> getLatestPosts(int postsNumber) {
		return null;
	}
}
