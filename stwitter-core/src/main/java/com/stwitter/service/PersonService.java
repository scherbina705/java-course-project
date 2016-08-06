package com.stwitter.service;

import com.stwitter.dto.PersonDto;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
public interface PersonService {
	Long savePerson(PersonDto person);

	void removePerson(Long personId);

	void addFriendship(Long personId, Long friendId);
}
