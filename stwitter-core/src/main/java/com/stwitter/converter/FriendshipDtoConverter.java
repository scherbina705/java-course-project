package com.stwitter.converter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dto.FriendshipDto;
import com.stwitter.entity.Friendship;
import org.dozer.DozerConverter;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by A.Shcherbina
 * on 10.08.2016.
 */
@Component
public class FriendshipDtoConverter extends DozerConverter<Friendship, FriendshipDto> {

    @Autowired
    private PersonDao personDao;

    public FriendshipDtoConverter() {
        super(Friendship.class, FriendshipDto.class);
    }

    @Override
    public FriendshipDto convertTo(Friendship friendship, FriendshipDto friendshipDto) {
        FriendshipDto dto = new FriendshipDto();
        dto.setFriendId(friendship.getFriend().getId());
        dto.setPersonId(friendship.getPerson().getId());
        dto.setDateFrom(new LocalDate(friendship.getDateFrom()));
        return dto;
    }

    @Override
    public Friendship convertFrom(FriendshipDto friendshipDto, Friendship friendship) {
        Friendship entity = new Friendship();
        entity.setFriend(personDao.findById(friendshipDto.getFriendId()));
        entity.setPerson(personDao.findById(friendshipDto.getPersonId()));
        entity.setDateFrom(friendshipDto.getDateFrom().toDate());
        return entity;
    }

}
