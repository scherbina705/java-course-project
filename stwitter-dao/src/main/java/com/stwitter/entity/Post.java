package com.stwitter.entity;

import javax.persistence.*;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "POST_ID")
    private Long id;

    private String title;

    private String content;
    @Column(name = "PLACE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date placeTime;

    @ManyToOne
    @MapsId

    @JoinColumn(name = "PERSON_ID",
            foreignKey = @ForeignKey(name = "FK_POST_PERSON")
    )
    private Person person;

    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(Date placeTime) {
        this.placeTime = placeTime;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Post post = (Post) o;

        return new EqualsBuilder()
                .append(getTitle(), post.getTitle())
                .append(getContent(), post.getContent())
                .append(getPlaceTime(), post.getPlaceTime())
                .append(getPerson(), post.getPerson())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getTitle())
                .append(getContent())
                .append(getPlaceTime())
                .append(getPerson())
                .toHashCode();
    }

}
