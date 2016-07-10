package com.stwitter.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Entity
@Table(name = "FRIENDSHIP")
public class Friendship implements Serializable {

    @EmbeddedId
    private PersonFriend personFriend;

    @Column(name = "DATE_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;

    public Friendship() {
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public PersonFriend getPersonFriend() {
        return personFriend;
    }

    public void setPersonFriend(PersonFriend personFriend) {
        this.personFriend = personFriend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friendship that = (Friendship) o;

        return personFriend.equals(that.personFriend);

    }

    @Override
    public int hashCode() {
        return personFriend.hashCode();
    }

    @Embeddable
    public static class PersonFriend implements Serializable {

        @ManyToOne
        @JoinColumn(name = "PERSON_ID", insertable = false, updatable = false,
                foreignKey = @ForeignKey(name = "FK1_FRIENDSHIP_PERSON")
        )
        private Person person;

        @ManyToOne
        @JoinColumn(name = "FRIEND_ID", insertable = false, updatable = false,
                foreignKey = @ForeignKey(name = "FK2_FRIENDSHIP_PERSON")
        )
        private Person friend;

        public PersonFriend() {
        }

        public Person getFriend() {
            return friend;
        }

        public void setFriend(Person friend) {
            this.friend = friend;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersonFriend that = (PersonFriend) o;

            return person.getId().equals(that.person.getId())
                    && friend.getId().equals(that.friend.getId());

        }

        @Override
        public int hashCode() {
            int result = person.getId().hashCode();
            result = 31 * result + friend.getId().hashCode();
            return result;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }
    }
}
