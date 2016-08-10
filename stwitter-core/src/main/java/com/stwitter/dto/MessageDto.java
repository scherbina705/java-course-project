package com.stwitter.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDateTime;

/**
 * (c) Swissquote 8/2/16
 *
 * @author Shcherbina A.
 */
public class MessageDto {
    private Long id;
    private String content;
    private LocalDateTime timeSent;
    private Long personFromId;
    private Long personToId;

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

    public Long getPersonFromId() {
        return personFromId;
    }

    public void setPersonFromId(Long personFromId) {
        this.personFromId = personFromId;
    }

    public Long getPersonToId() {
        return personToId;
    }

    public void setPersonToId(Long personToId) {
        this.personToId = personToId;
    }

    public LocalDateTime getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(LocalDateTime timeSent) {
        this.timeSent = timeSent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MessageDto that = (MessageDto) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(content, that.content)
                .append(timeSent, that.timeSent)
                .append(personFromId, that.personFromId)
                .append(personToId, that.personToId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(content)
                .append(timeSent)
                .append(personFromId)
                .append(personToId)
                .toHashCode();
    }
}
