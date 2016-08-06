package com.stwitter.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDate;

/**
 * (c) Swissquote 8/3/16
 *
 * @author Shcherbina A.
 */
public class FriendshipDto {
    private PersonDto person;
    private PersonDto friend;
    private LocalDate dateFrom;

    public FriendshipDto() {
    }

    public FriendshipDto(LocalDate dateFrom, PersonDto friend, PersonDto person) {
        this.dateFrom = dateFrom;
        this.friend = friend;
        this.person = person;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public PersonDto getFriend() {
        return friend;
    }

    public void setFriend(PersonDto friend) {
        this.friend = friend;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
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

        FriendshipDto that = (FriendshipDto) o;

        return new EqualsBuilder()
                .append(person, that.person)
                .append(friend, that.friend)
                .append(dateFrom, that.dateFrom)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(person)
                .append(friend)
                .append(dateFrom)
                .toHashCode();
    }
}
