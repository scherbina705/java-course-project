package com.stwitter.entity;

import javax.persistence.*;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Entity
@Table(name = "Place")
public class Place {
    @Id
    @GeneratedValue
    @Column(name = "PLACE_ID")
    private Long id;

    private String title;

    private String description;

    //TODO: Find out in which format to store
    private Double latitude;

    //TODO: Find out in which format to store
    private Double longtitude;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "POST_ID",
            foreignKey = @ForeignKey(name = "FK_PLACE_POST")
    )
    private Post post;

    public Place() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        return id.equals(place.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
