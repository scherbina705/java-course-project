package com.stwitter.converter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dto.MessageDto;
import com.stwitter.entity.Message;
import org.dozer.DozerConverter;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by A.Shcherbina
 * on 10.08.2016.
 */
@Component
public class MessageDtoConverter extends DozerConverter<Message, MessageDto> {
    @Autowired
    private PersonDao personDao;

    public MessageDtoConverter() {
        super(Message.class, MessageDto.class);
    }

    @Override
    public MessageDto convertTo(Message message, MessageDto messageDto) {
        MessageDto dto = new MessageDto();
        dto.setId(message.getId());
        dto.setContent(message.getContent());
        dto.setPersonFromId(message.getPersonFrom().getId());
        dto.setPersonToId(message.getPersonTo().getId());
        dto.setTimeSent(new LocalDateTime(message.getTimeSent()));
        return dto;
    }

    @Override
    public Message convertFrom(MessageDto messageDto, Message message) {
        Message entity = new Message();
        entity.setId(messageDto.getId());
        entity.setContent(messageDto.getContent());
        entity.setTimeSent(messageDto.getTimeSent().toDate());
        entity.setPersonFrom(personDao.findById(messageDto.getPersonFromId()));
        entity.setPersonTo(personDao.findById(messageDto.getPersonToId()));
        return entity;
    }
}
