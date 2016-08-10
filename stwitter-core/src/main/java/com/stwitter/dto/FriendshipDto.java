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
    private Long personId;
    private Long friendId;
    private LocalDate dateFrom;

    public FriendshipDto() {
    }

    public FriendshipDto(LocalDate dateFrom, Long friendId, Long personId) {
        this.dateFrom = dateFrom;
        this.friendId = friendId;
        this.personId = personId;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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
                .append(personId, that.personId)
                .append(friendId, that.friendId)
                .append(dateFrom, that.dateFrom)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(personId)
                .append(friendId)
                .append(dateFrom)
                .toHashCode();
    }
}
