package com.stwitter.entity;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    @Id
    @ManyToOne
    @JoinColumn(name = "PERSON_ID", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK1_FRIENDSHIP_PERSON")
    )
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "FRIEND_ID", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK2_FRIENDSHIP_PERSON")
    )
    private Person friend;

    @Column(name = "DATE_FROM")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    public Friendship() {

    }

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Friendship that = (Friendship) o;

        return new EqualsBuilder()
                .append(getPerson(), that.getPerson())
                .append(getFriend(), that.getFriend())
                .append(getDateFrom(), that.getDateFrom())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPerson())
                .append(getFriend())
                .append(getDateFrom())
                .toHashCode();
    }
}
