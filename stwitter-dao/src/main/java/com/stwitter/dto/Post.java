package com.stwitter.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
public class Post {
    private LocalDate creationDate;
    private LocalTime creationTime;
    private Long postId;
    private String postText;
    private User author;

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalTime creationTime) {
        this.creationTime = creationTime;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
