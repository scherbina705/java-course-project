package stwitter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stwitter.dto.HobbyDto;
import com.stwitter.dto.PersonDto;
import com.stwitter.entity.Hobby;
import com.stwitter.entity.Person;

import stwitter.util.TestUtils;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class PersonDozerMappingTest {

	@Autowired
	private DozerBeanMapper mapper;

	@Test
	public void testPersonEntityToDtoMapping() {
		//GIVEN
		Person entity = getPersonEntity();
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
		assertThat(actualDto.getHobbies()).isEqualTo(expectedDto.getHobbies());
	}

	@Test
	public void testPersonDtoToEntityMapping() {
		//GIVEN
		PersonDto dto = getPersonDto();
		Person expectedEntity = getPersonEntity();

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
		PersonDto dto = TestUtils.getPersonDto();
		HobbyDto hobby1Dto = TestUtils.getHobbyDto();
		HobbyDto hobby2Dto = TestUtils.getHobbyDto();
		hobby1Dto.setId(1L);
		hobby2Dto.setId(2L);
		hobby2Dto.setTitle("Title 2");
		dto.getHobbies().add(hobby1Dto);
		dto.getHobbies().add(hobby2Dto);
		return dto;
	}

	private Person getPersonEntity() {
		Hobby hobby1 = TestUtils.getHobby();
		Hobby hobby2 = TestUtils.getHobby();
		hobby1.setId(1L);
		hobby2.setId(2L);
		hobby2.setTitle("Title 2");
		Person p = TestUtils.getPerson();
		p.getHobbies().add(hobby1);
		p.getHobbies().add(hobby2);
		return p;
	}
}
