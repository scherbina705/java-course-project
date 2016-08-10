package stwitter.converter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dto.MessageDto;
import com.stwitter.entity.Message;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import stwitter.util.TestConverterUtils;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Autowired
    private PersonDao personDao;

    @Test
    @Transactional
    @Rollback(true)
    public void testMessageEntityToDtoMapping() {
        //GIVEN
        Message entity = getMessageEntity();
        MessageDto expectedDto = getMessageDto();

        //WHEN
        MessageDto actualDto = mapper.map(entity, MessageDto.class);

        //THEN
        assertThat(actualDto.getId()).isEqualTo(expectedDto.getId());
        assertThat(actualDto.getContent()).isEqualTo(expectedDto.getContent());
        assertThat(actualDto.getPersonFromId()).isEqualTo(expectedDto.getPersonFromId());
        assertThat(actualDto.getPersonToId()).isEqualTo(expectedDto.getPersonToId());
        assertThat(actualDto.getTimeSent()).isEqualTo(expectedDto.getTimeSent());

    }

    @Test
    @Transactional
    @Rollback(true)
    public void testMessageDtoToEntityMapping() {
        //GIVEN
        MessageDto dto = getMessageDto();
        Message expectedEntity = getMessageEntity();
        expectedEntity.getPersonFrom().setId(null);
        Long expectedId = personDao.save(expectedEntity.getPersonFrom());
        dto.setPersonFromId(expectedId);
        dto.setPersonToId(expectedId);

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
        dto.setPersonFromId(TestConverterUtils.getPersonDto().getId());
        dto.setPersonToId(TestConverterUtils.getPersonDto().getId());
        dto.setTimeSent(TestConverterUtils.getTestDateTime());
        return dto;
    }

    private Message getMessageEntity() {
        Message m = new Message();
        m.setId(1L);
        m.setContent("Content");
        m.setPersonFrom(TestConverterUtils.getPerson());
        m.setPersonTo(TestConverterUtils.getPerson());
        m.setTimeSent(TestConverterUtils.getTestDateTime().toDate());
        return m;
    }
}
