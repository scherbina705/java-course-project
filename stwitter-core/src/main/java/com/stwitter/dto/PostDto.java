package com.stwitter.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDateTime;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
public class PostDto {
    private LocalDateTime creationDateTime;
    private Long postId;
    private String postContent;
    private String postTitle;
    private Long authorPersonId;

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Long getAuthorPersonId() {
        return authorPersonId;
    }

    public void setAuthorPersonId(Long authorPersonId) {
        this.authorPersonId = authorPersonId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PostDto postDto = (PostDto) o;

        return new EqualsBuilder()
                .append(creationDateTime, postDto.creationDateTime)
                .append(postId, postDto.postId)
                .append(postContent, postDto.postContent)
                .append(postTitle, postDto.postTitle)
                .append(authorPersonId, postDto.authorPersonId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(creationDateTime)
                .append(postId)
                .append(postContent)
                .append(postTitle)
                .append(authorPersonId)
                .toHashCode();
    }
}
