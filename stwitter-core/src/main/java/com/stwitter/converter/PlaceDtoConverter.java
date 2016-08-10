package com.stwitter.converter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dto.PlaceDto;
import com.stwitter.entity.Place;
import org.dozer.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by A.Shcherbina
 * on 10.08.2016.
 */
@Component
public class PlaceDtoConverter extends DozerConverter<Place, PlaceDto> {

    @Autowired
    private PersonDao personDao;

    public PlaceDtoConverter() {
        super(Place.class, PlaceDto.class);
    }

    @Override
    public PlaceDto convertTo(Place place, PlaceDto placeDto) {
        PlaceDto dto = new PlaceDto();
        dto.setId(place.getId());
        dto.setDescription(place.getDescription());
        dto.setLatitude(place.getLatitude());
        dto.setLongtitude(place.getLongtitude());
        dto.setTitle(place.getTitle());
        place.getPersons().stream().forEach(person -> dto.getPersonsId().add(person.getId()));
        return dto;
    }

    @Override
    public Place convertFrom(PlaceDto placeDto, Place place) {
        Place entity = new Place();
        entity.setId(placeDto.getId());
        entity.setDescription(placeDto.getDescription());
        entity.setLatitude(placeDto.getLatitude());
        entity.setLongtitude(placeDto.getLongtitude());
        entity.setTitle(placeDto.getTitle());
        placeDto.getPersonsId().stream().forEach(person -> entity.getPersons().add(personDao.findById(person)));
        return entity;
    }
}
