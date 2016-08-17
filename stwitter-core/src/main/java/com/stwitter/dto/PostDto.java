package com.stwitter.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.stwitter.converter.CustomLocalDateTimeDeserializer;
import com.stwitter.converter.CustomLocalDateTimeSerializer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDateTime;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
public class PostDto {
    private Long id;
    private String title;
    private String content;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime placeTime;
    private String authorLogin;

    private Long postLikes;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorLogin() {
        return authorLogin;
    }

    public void setAuthorLogin(String authorLogin) {
        this.authorLogin = authorLogin;
    }

    public LocalDateTime getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(LocalDateTime placeTime) {
        this.placeTime = placeTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                .append(id, postDto.id)
                .append(title, postDto.title)
                .append(content, postDto.content)
                .append(placeTime, postDto.placeTime)
                .append(authorLogin, postDto.authorLogin)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .append(content)
                .append(placeTime)
                .append(authorLogin)
                .toHashCode();
    }

    public Long getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(Long postLikes) {
        this.postLikes = postLikes;
    }
}
