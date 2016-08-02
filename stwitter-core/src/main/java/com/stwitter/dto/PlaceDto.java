package com.stwitter.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * (c) Swissquote 8/2/16
 *
 * @author Shcherbina A.
 */
public class PlaceDto {
    private Long id;
    private String title;
    private String description;
    private Double latitude;
    private Double longtitude;
    private Long postId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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

        PlaceDto placeDto = (PlaceDto) o;

        return new EqualsBuilder()
                .append(id, placeDto.id)
                .append(title, placeDto.title)
                .append(description, placeDto.description)
                .append(latitude, placeDto.latitude)
                .append(longtitude, placeDto.longtitude)
                .append(postId, placeDto.postId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .append(description)
                .append(latitude)
                .append(longtitude)
                .append(postId)
                .toHashCode();
    }
}
