package stwitter.converter;

import com.stwitter.dto.HobbyDto;
import com.stwitter.entity.Hobby;
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
public class HobbyDozerMappingTest {

    @Autowired
    private DozerBeanMapper mapper;

    @Test
    @Transactional
    @Rollback(true)
    public void testHobbyDtoToEntityMapping() {
        //GIVEN
        HobbyDto dto = TestConverterUtils.getHobbyDto();
        Hobby expectedEntity = TestConverterUtils.getHobby();

        //WHEN
        Hobby actualEntity = mapper.map(dto, Hobby.class);

        //THEN
        assertThat(actualEntity.getId()).isEqualTo(expectedEntity.getId());
        assertThat(actualEntity.getDescription()).isEqualTo(expectedEntity.getDescription());
        assertThat(actualEntity.getTitle()).isEqualTo(expectedEntity.getTitle());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testHobbyEntityToDtoMapping() {
        //GIVEN
        HobbyDto expectedDto = TestConverterUtils.getHobbyDto();
        Hobby entity = TestConverterUtils.getHobby();

        //WHEN
        HobbyDto actualDto = mapper.map(entity, HobbyDto.class);

        //THEN
        assertThat(actualDto.getId()).isEqualTo(entity.getId());
        assertThat(actualDto.getDescription()).isEqualTo(entity.getDescription());
        assertThat(actualDto.getTitle()).isEqualTo(entity.getTitle());
    }

}
