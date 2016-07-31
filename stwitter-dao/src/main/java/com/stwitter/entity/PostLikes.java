package com.stwitter.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Entity
@Table(name = "POST_LIKES")
public class PostLikes implements Serializable {

    @ManyToOne
    @MapsId
    @JoinColumn(name = "POST_ID", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK_POST_LIKES_POST")
    )
    private Post post;

    @Id
    @ManyToOne
    @MapsId
    @JoinColumn(name = "PERSON_ID", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK_POST_LIKES_PERSON")
    )
    private Person person;

    public PostLikes(Person person, Post post) {
        this.person = person;
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(person)
                .append(post)
                .toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PostLikes postLikes = (PostLikes) o;

        return new EqualsBuilder()
                .append(person, postLikes.person)
                .append(post, postLikes.post)
                .isEquals();
    }
}
