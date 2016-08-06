package stwitter.converter;

import com.stwitter.dto.FriendshipDto;
import com.stwitter.entity.Friendship;
import org.dozer.DozerBeanMapper;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import stwitter.util.TestConverterUtils;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * (c) Swissquote 8/5/16
 *
 * @author Shcherbina A.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class FriendshipDozerMappingTest {

    private static final LocalDate TEST_DATE = LocalDate.now();

    @Autowired
    private DozerBeanMapper mapper;

    @Test
    public void testFriendshipDtoToEntityMapping() {
        //GIVEN
        FriendshipDto dto = getFriendshipDto();
        Friendship expectedEntity = getFriendshipEntity();

        //WHEN
        Friendship actualEntity = mapper.map(dto, Friendship.class);

        //THEN
        assertThat(actualEntity.getFriend()).isEqualTo(expectedEntity.getFriend());
        assertThat(actualEntity.getPerson()).isEqualTo(expectedEntity.getPerson());
        assertThat(actualEntity.getDateFrom()).isEqualTo(expectedEntity.getDateFrom());
    }

    @Test
    public void testFriendshipEntityToDtoMapping() {
        //GIVEN
        FriendshipDto expectedDto = getFriendshipDto();
        Friendship entity = getFriendshipEntity();

        //WHEN
        FriendshipDto actualDto = mapper.map(expectedDto, FriendshipDto.class);

        //THEN
        assertThat(actualDto.getFriend()).isEqualTo(expectedDto.getFriend());
        assertThat(actualDto.getPerson()).isEqualTo(expectedDto.getPerson());
        assertThat(actualDto.getDateFrom()).isEqualTo(expectedDto.getDateFrom());
    }

    private FriendshipDto getFriendshipDto() {
        FriendshipDto f = new FriendshipDto();
        f.setDateFrom(TEST_DATE);
        f.setPerson(TestConverterUtils.getPersonDto());
        f.setFriend(TestConverterUtils.getPersonDto());
        return f;
    }

    private Friendship getFriendshipEntity() {
        Friendship f = new Friendship();
        f.setDateFrom(TEST_DATE.toDate());
        f.setPerson(TestConverterUtils.getPerson());
        f.setFriend(TestConverterUtils.getPerson());
        return f;
    }

}
