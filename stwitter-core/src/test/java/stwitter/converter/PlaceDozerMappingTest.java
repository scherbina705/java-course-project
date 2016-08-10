package stwitter.converter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PlaceDto;
import com.stwitter.entity.Person;
import com.stwitter.entity.Place;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import stwitter.util.TestConverterUtils;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * (c) Swissquote 8/5/16
 *
 * @author Shcherbina A.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class PlaceDozerMappingTest {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private PersonDao personDao;

    @Test
    public void testPlaceEntityToDtoMapping() {
        //GIVEN
        Place entity = getPlaceEntity();
        PlaceDto expectedDto = getPlaceDto();

        //WHEN
        PlaceDto actualDto = mapper.map(entity, PlaceDto.class);

        //THEN
        assertThat(actualDto.getId()).isEqualTo(expectedDto.getId());
        assertThat(actualDto.getDescription()).isEqualTo(expectedDto.getDescription());
        assertThat(actualDto.getLatitude()).isEqualTo(expectedDto.getLatitude());
        assertThat(actualDto.getLongtitude()).isEqualTo(expectedDto.getLongtitude());
        assertThat(actualDto.getPersonsId()).isEqualTo(expectedDto.getPersonsId());

    }

    @Test
    @Transactional
    @Rollback
    public void testPlaceDtoToEntityMapping() {
        //GIVEN
        PlaceDto dto = getPlaceDto();
        Place expectedEntity = getPlaceEntity();
        Set<Long> expectedIds = new HashSet<>();
        expectedEntity.getPersons().stream().forEach(person -> expectedIds.add(personDao.save(person)));
        dto.setPersonsId(expectedIds);

        //WHEN
        Place actualEntity = mapper.map(dto, Place.class);

        //THEN
        assertThat(actualEntity.getId()).isEqualTo(expectedEntity.getId());
        assertThat(actualEntity.getDescription()).isEqualTo(expectedEntity.getDescription());
        assertThat(actualEntity.getLatitude()).isEqualTo(expectedEntity.getLatitude());
        assertThat(actualEntity.getLongtitude()).isEqualTo(expectedEntity.getLongtitude());
        assertThat(actualEntity.getPersons()).isEqualTo(expectedEntity.getPersons());
    }

    private PlaceDto getPlaceDto() {
        PlaceDto dto = new PlaceDto();
        PersonDto p1 = TestConverterUtils.getPersonDto();
        PersonDto p2 = TestConverterUtils.getPersonDto();
        p2.setId(2L);
        p2.setLogin("login2");
        dto.setTitle("Title");
        dto.setId(1L);
        dto.setDescription("Description");
        dto.setLatitude(1.5F);
        dto.setLatitude(2.5F);
        dto.getPersonsId().add(p1.getId());
        dto.getPersonsId().add(p2.getId());
        return dto;
    }

    private Place getPlaceEntity() {
        Place p = new Place();
        Person p1 = TestConverterUtils.getPerson();
        Person p2 = TestConverterUtils.getPerson();
        p2.setId(2L);
        p2.setLogin("login2");
        p.setTitle("Title");
        p.setId(1L);
        p.setDescription("Description");
        p.setLatitude(1.5F);
        p.setLatitude(2.5F);
        p.getPersons().add(p1);
        p.getPersons().add(p2);
        return p;
    }
}
