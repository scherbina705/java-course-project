package com.stwitter.service;

import java.util.Set;

import com.stwitter.dto.HobbyDto;
import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PlaceDto;


/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
public interface InterestService {
	Long addPlace(PlaceDto placeDto);

	Long addHobby(HobbyDto hobbyDto);

	Set<PersonDto> getPeopleWithHobby(String title);

	Set<PersonDto> getPeopleFromPlace();
}
