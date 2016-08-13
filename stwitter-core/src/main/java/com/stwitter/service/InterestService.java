package com.stwitter.service;

import com.stwitter.dto.HobbyDto;
import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PlaceDto;
import com.stwitter.entity.Place;

import java.util.Set;


/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
public interface InterestService {
    Long addPlace(PlaceDto placeDto);

    Long addHobby(HobbyDto hobbyDto);

    Set<PersonDto> getPeopleWithHobby(String title);

    Set<PersonDto> getPeopleFromPlace(Place place);

    Set<HobbyDto> getAllHobbies();
}
