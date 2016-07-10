package com.stwitter.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Entity
@Table(name = "POST_LIKES")
public class PostLikes implements Serializable {

    @EmbeddedId
    private PersonPost personPost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostLikes postLikes = (PostLikes) o;

        return personPost.equals(postLikes.personPost);

    }

    @Override
    public int hashCode() {
        return personPost.hashCode();
    }

    @Embeddable
    public static class PersonPost implements Serializable {

        @ManyToOne
        @JoinColumn(name = "PERSON_ID", insertable = false, updatable = false,
                foreignKey = @ForeignKey(name = "FK_POST_LIKES_PERSON")
        )
        private Person person;

        @ManyToOne
        @JoinColumn(name = "POST_ID", insertable = false, updatable = false,
                foreignKey = @ForeignKey(name = "FK_POST_LIKES_POST")
        )
        private Post post;

        public PersonPost() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersonPost that = (PersonPost) o;

            return person.getId().equals(that.person.getId())
                    && post.getId().equals(that.post.getId());
        }

        @Override
        public int hashCode() {
            int result = person.hashCode();
            result = 31 * result + post.hashCode();
            return result;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public Post getPost() {
            return post;
        }

        public void setPost(Post post) {
            this.post = post;
        }

    }
}
