package stwitter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stwitter.dto.PlaceDto;
import com.stwitter.entity.Place;

import stwitter.util.TestUtils;

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
		assertThat(actualDto.getPerson()).isEqualTo(expectedDto.getPerson());

	}

	@Test
	public void testPlaceDtoToEntityMapping() {
		//GIVEN
		PlaceDto dto = getPlaceDto();
		Place expectedEntity = getPlaceEntity();

		//WHEN
		Place actualEntity = mapper.map(dto, Place.class);

		//THEN
		assertThat(actualEntity.getId()).isEqualTo(expectedEntity.getId());
		assertThat(actualEntity.getDescription()).isEqualTo(expectedEntity.getDescription());
		assertThat(actualEntity.getLatitude()).isEqualTo(expectedEntity.getLatitude());
		assertThat(actualEntity.getLongtitude()).isEqualTo(expectedEntity.getLongtitude());
		assertThat(actualEntity.getPerson()).isEqualTo(expectedEntity.getPerson());

	}

	private PlaceDto getPlaceDto() {
		PlaceDto dto = new PlaceDto();
		dto.setTitle("Title");
		dto.setId(1L);
		dto.setDescription("Description");
		dto.setLatitude(1.5F);
		dto.setLatitude(2.5F);
		dto.setPerson(TestUtils.getPersonDto());
		return dto;
	}

	private Place getPlaceEntity() {
		Place p = new Place();
		p.setTitle("Title");
		p.setId(1L);
		p.setDescription("Description");
		p.setLatitude(1.5F);
		p.setLatitude(2.5F);
		p.setPerson(TestUtils.getPerson());
		return p;
	}
}
