package stwitter.converter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dto.FriendshipDto;
import com.stwitter.entity.Friendship;
import org.dozer.DozerBeanMapper;
import org.joda.time.LocalDate;
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
public class FriendshipDozerMappingTest {

    private static final LocalDate TEST_DATE = LocalDate.now();

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private PersonDao personDao;

    @Test
    @Transactional
    @Rollback(true)
    public void testFriendshipDtoToEntityMapping() {
        //GIVEN
        Friendship expectedEntity = getFriendshipEntity();
        expectedEntity.getPerson().setId(null);
        expectedEntity.getFriend().setId(null);
        expectedEntity.getFriend().setLogin("any_other_login");
        Long expectedPersonId = personDao.save(expectedEntity.getPerson());
        Long expectedFriendId = personDao.save(expectedEntity.getFriend());

        FriendshipDto dto = getFriendshipDto();
        dto.setPersonId(expectedPersonId);
        dto.setFriendId(expectedFriendId);

        //WHEN
        Friendship actualEntity = mapper.map(dto, Friendship.class);

        //THEN
        assertThat(actualEntity.getFriend()).isEqualTo(expectedEntity.getFriend());
        assertThat(actualEntity.getPerson()).isEqualTo(expectedEntity.getPerson());
        assertThat(actualEntity.getDateFrom()).isEqualTo(expectedEntity.getDateFrom());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFriendshipEntityToDtoMapping() {
        //GIVEN
        FriendshipDto expectedDto = getFriendshipDto();
        Friendship entity = getFriendshipEntity();

        //WHEN
        FriendshipDto actualDto = mapper.map(entity, FriendshipDto.class);

        //THEN
        assertThat(actualDto.getFriendId()).isEqualTo(expectedDto.getFriendId());
        assertThat(actualDto.getPersonId()).isEqualTo(expectedDto.getPersonId());
        assertThat(actualDto.getDateFrom()).isEqualTo(expectedDto.getDateFrom());
    }

    private FriendshipDto getFriendshipDto() {
        FriendshipDto f = new FriendshipDto();
        f.setDateFrom(TEST_DATE);
        f.setPersonId(TestConverterUtils.getPersonDto().getId());
        f.setFriendId(TestConverterUtils.getPersonDto().getId());
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
