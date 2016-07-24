package java.com.stwitter.service;

import com.stwitter.dto.Post;

import java.util.List;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
public interface PostService {
    void getLatestPostsForUser();

    void getAllLikesForPost();

    List<Post> getLatestPosts(Integer postsNumber);
}
