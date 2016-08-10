package stwitter.converter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dto.PersonDto;
import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import stwitter.util.TestServiceUtils;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class PersonDozerMappingTest {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private DozerBeanMapper mapper;

    @Test
    public void testPersonEntityToDtoMapping() {
        //GIVEN
        Person entity = getPersonEntity();
        Hobby hobby1 = TestServiceUtils.getHobby();
        Hobby hobby2 = TestServiceUtils.getHobby();
        hobby1.setId(1L);
        hobby2.setId(2L);
        hobby2.setTitle("Title 2");
        entity.getHobbies().add(hobby1);
        entity.getHobbies().add(hobby2);
        PersonDto expectedDto = getPersonDto();

        //WHEN
        PersonDto actualDto = mapper.map(entity, PersonDto.class);

        //THEN
        assertThat(actualDto.getId()).isEqualTo(expectedDto.getId());
        assertThat(actualDto.getEmail()).isEqualTo(expectedDto.getEmail());
        assertThat(actualDto.getBirthday()).isEqualTo(expectedDto.getBirthday());
        assertThat(actualDto.getFirstName()).isEqualTo(expectedDto.getFirstName());
        assertThat(actualDto.getLastName()).isEqualTo(expectedDto.getLastName());
        assertThat(actualDto.getLogin()).isEqualTo(expectedDto.getLogin());
        assertThat(actualDto.getPassword()).isEqualTo(expectedDto.getPassword());
        assertThat(actualDto.getHobbiesId()).isEqualTo(expectedDto.getHobbiesId());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testPersonDtoToEntityMapping() {
        //GIVEN
        PersonDto dto = getPersonDto();
        Person expectedEntity = getPersonEntity();
        Hobby hobby1 = TestServiceUtils.getHobby();
        Hobby hobby2 = TestServiceUtils.getHobby();
        hobby2.setTitle("Title 2");
        expectedEntity.getHobbies().add(hobby1);
        expectedEntity.getHobbies().add(hobby2);
        Long expectedId = personDao.save(expectedEntity);
        dto.setId(expectedId);

        //WHEN
        Person actualEntity = mapper.map(dto, Person.class);

        //THEN
        assertThat(actualEntity.getId()).isEqualTo(expectedEntity.getId());
        assertThat(actualEntity.getEmail()).isEqualTo(expectedEntity.getEmail());
        assertThat(actualEntity.getBirthday()).isEqualTo(expectedEntity.getBirthday());
        assertThat(actualEntity.getFirstName()).isEqualTo(expectedEntity.getFirstName());
        assertThat(actualEntity.getLastName()).isEqualTo(expectedEntity.getLastName());
        assertThat(actualEntity.getLogin()).isEqualTo(expectedEntity.getLogin());
        assertThat(actualEntity.getPassword()).isEqualTo(expectedEntity.getPassword());
        assertThat(actualEntity.getHobbies()).isEqualTo(expectedEntity.getHobbies());
    }

    private PersonDto getPersonDto() {
        PersonDto dto = TestServiceUtils.getPersonDto();
        dto.getHobbiesId().add(1L);
        dto.getHobbiesId().add(2L);
        return dto;
    }

    private Person getPersonEntity() {
        return TestServiceUtils.getPerson();
    }
}
