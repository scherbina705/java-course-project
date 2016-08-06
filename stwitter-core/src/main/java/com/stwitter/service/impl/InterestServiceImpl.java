package com.stwitter.service.impl;

import com.stwitter.dao.HobbyDao;
import com.stwitter.dao.PersonDao;
import com.stwitter.dao.PlaceDao;
import com.stwitter.dto.HobbyDto;
import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PlaceDto;
import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;
import com.stwitter.entity.Place;
import com.stwitter.service.InterestService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private HobbyDao hobbyDao;

    @Autowired
    private PlaceDao placeDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private DozerBeanMapper mapper;


    @Override
    public Long addPlace(PlaceDto placeDto) {
        return placeDao.save(mapper.map(placeDto, Place.class));
    }

    @Override
    public Long addHobby(HobbyDto hobbyDto) {
        return hobbyDao.save(mapper.map(hobbyDto, Hobby.class));
    }

    @Override
    public Set<PersonDto> getPeopleWithHobby(String title) {
        Hobby hobby = hobbyDao.findHobbyByTitle(title);
        Set<Person> persons = personDao.findByHobby(hobby);
        Set<PersonDto> personsDto = mapper.map(persons, Set.class);
        return personsDto;
    }

    @Override
    public Set<PersonDto> getPeopleFromPlace(Place place) {
        Set<Person> persons = personDao.findByPlace(place);
        Set<PersonDto> personsDto = mapper.map(persons, Set.class);
        return personsDto;
    }
}
