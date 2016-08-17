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
        Long firstHobbyId = 1L;
        Long secondHobbyId = 2L;
        //GIVEN
        Person entity = TestServiceUtils.getPerson();
        Hobby hobby1 = TestServiceUtils.getHobby();
        Hobby hobby2 = TestServiceUtils.getHobby();
        hobby1.setId(firstHobbyId);
        hobby2.setId(secondHobbyId);
        hobby2.setTitle("Title 2");
        entity.getHobbies().add(hobby1);
        entity.getHobbies().add(hobby2);
        PersonDto expectedDto = TestServiceUtils.getPersonDto();
        expectedDto.getHobbiesId().add(firstHobbyId);
        expectedDto.getHobbiesId().add(secondHobbyId);

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
        Person expectedEntity = TestServiceUtils.getPerson();
        Hobby hobby1 = TestServiceUtils.getHobby();
        Hobby hobby2 = TestServiceUtils.getHobby();
        hobby2.setTitle("Title 2");
        expectedEntity.getHobbies().add(hobby1);
        expectedEntity.getHobbies().add(hobby2);
        Long expectedId = personDao.save(expectedEntity);

        PersonDto dto = TestServiceUtils.getPersonDto();
        dto.setId(expectedId);
        dto.getHobbiesId().add(hobby1.getId());
        dto.getHobbiesId().add(hobby2.getId());

        //WHEN
        Person actualEntity = mapper.map(dto, Person.class);

        //THEN
        assertThat(actualEntity.getId()).isEqualTo(expectedId);
        assertThat(actualEntity.getEmail()).isEqualTo(expectedEntity.getEmail());
        assertThat(actualEntity.getBirthday()).isEqualTo(expectedEntity.getBirthday());
        assertThat(actualEntity.getFirstName()).isEqualTo(expectedEntity.getFirstName());
        assertThat(actualEntity.getLastName()).isEqualTo(expectedEntity.getLastName());
        assertThat(actualEntity.getLogin()).isEqualTo(expectedEntity.getLogin());
        assertThat(actualEntity.getPassword()).isEqualTo(expectedEntity.getPassword());
        assertThat(actualEntity.getHobbies()).isEqualTo(expectedEntity.getHobbies());
    }
}
