package com.stwitter.dto;


import com.stwitter.entity.Message;
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
    private PersonDto personFrom;
    private PersonDto personTo;

    public static MessageDto convertToDto(Message entity) {
        MessageDto m = new MessageDto();
        m.setContent(entity.getContent());
        m.setPersonFrom(PersonDto.convertToDto(entity.getPersonFrom()));
        m.setPersonTo(PersonDto.convertToDto(entity.getPersonTo()));
        m.setId(entity.getId());
        return m;
    }

    public static Message convertToEntity(MessageDto dto) {
        Message m = new Message();
        m.setContent(dto.getContent());
        m.setPersonFrom(PersonDto.convertToEntity(dto.getPersonFrom()));
        m.setPersonTo(PersonDto.convertToEntity(dto.getPersonTo()));
        m.setId(dto.getId());
        return m;
    }

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

    public PersonDto getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(PersonDto personFrom) {
        this.personFrom = personFrom;
    }

    public PersonDto getPersonTo() {
        return personTo;
    }

    public void setPersonTo(PersonDto personTo) {
        this.personTo = personTo;
    }

    public LocalDateTime getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(LocalDateTime timeSent) {
        this.timeSent = timeSent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageDto that = (MessageDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!content.equals(that.content)) return false;
        if (!timeSent.equals(that.timeSent)) return false;
        if (!personFrom.equals(that.personFrom)) return false;
        return personTo.equals(that.personTo);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + content.hashCode();
        result = 31 * result + timeSent.hashCode();
        result = 31 * result + personFrom.hashCode();
        result = 31 * result + personTo.hashCode();
        return result;
    }
}
