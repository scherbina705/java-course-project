package stwitter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stwitter.dto.MessageDto;
import com.stwitter.entity.Message;

import stwitter.util.TestUtils;

/**
 * (c) Swissquote 8/5/16
 *
 * @author Shcherbina A.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class MessageDozerMappingTest {

	@Autowired
	private DozerBeanMapper mapper;

	@Test
	public void testMessageEntityToDtoMapping() {
		//GIVEN
		Message entity = getMessageEntity();
		MessageDto expectedDto = getMessageDto();

		//WHEN
		MessageDto actualDto = mapper.map(entity, MessageDto.class);

		//THEN
		assertThat(actualDto.getId()).isEqualTo(expectedDto.getId());
		assertThat(actualDto.getContent()).isEqualTo(expectedDto.getContent());
		assertThat(actualDto.getPersonFrom()).isEqualTo(expectedDto.getPersonFrom());
		assertThat(actualDto.getPersonTo()).isEqualTo(expectedDto.getPersonTo());
		assertThat(actualDto.getTimeSent()).isEqualTo(expectedDto.getTimeSent());

	}

	@Test
	public void testMessageDtoToEntityMapping() {
		//GIVEN
		MessageDto dto = getMessageDto();
		Message expectedEntity = getMessageEntity();

		//WHEN
		Message actualEntity = mapper.map(dto, Message.class);

		//THEN
		assertThat(actualEntity.getId()).isEqualTo(expectedEntity.getId());
		assertThat(actualEntity.getContent()).isEqualTo(expectedEntity.getContent());
		assertThat(actualEntity.getPersonFrom()).isEqualTo(expectedEntity.getPersonFrom());
		assertThat(actualEntity.getPersonTo()).isEqualTo(expectedEntity.getPersonTo());
		assertThat(actualEntity.getTimeSent()).isEqualTo(expectedEntity.getTimeSent());
	}

	private MessageDto getMessageDto() {
		MessageDto dto = new MessageDto();
		dto.setId(1L);
		dto.setContent("Content");
		dto.setPersonFrom(TestUtils.getPersonDto());
		dto.setPersonFrom(TestUtils.getPersonDto());
		dto.setTimeSent(TestUtils.getTestDateTime());
		return dto;
	}

	private Message getMessageEntity() {
		Message m = new Message();
		m.setId(1L);
		m.setContent("Content");
		m.setPersonFrom(TestUtils.getPerson());
		m.setPersonFrom(TestUtils.getPerson());
		m.setTimeSent(TestUtils.getTestDateTime().toDate());
		return m;
	}
}
