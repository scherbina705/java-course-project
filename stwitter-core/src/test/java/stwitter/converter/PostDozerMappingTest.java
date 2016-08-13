package stwitter.converter;

import com.stwitter.dao.PersonDao;
import com.stwitter.dao.PostDao;
import com.stwitter.dto.PostDto;
import com.stwitter.entity.Person;
import com.stwitter.entity.Post;
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
public class PostDozerMappingTest {
    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PostDao postDao;

    @Test
    @Transactional
    @Rollback
    public void testPostEntityToDtoMapping() {
        //GIVEN
        Person person = TestConverterUtils.getPerson();
        person.setId(null);
        personDao.save(person);
        String expectedPersonLogin = person.getLogin();

        Post entity = TestConverterUtils.getPost();
        entity.setId(null);
        entity.setPerson(person);
        Long expectedId = postDao.save(entity);

        PostDto expectedDto = TestConverterUtils.getPostDto();

        //WHEN
        PostDto actualDto = mapper.map(entity, PostDto.class);

        //THEN
        assertThat(actualDto.getId()).isEqualTo(expectedId);
        assertThat(actualDto.getContent()).isEqualTo(expectedDto.getContent());
        assertThat(actualDto.getTitle()).isEqualTo(expectedDto.getTitle());
        assertThat(actualDto.getPlaceTime()).isEqualTo(expectedDto.getPlaceTime());
        assertThat(actualDto.getAuthorLogin()).isEqualTo(expectedPersonLogin);
    }

    @Test
    @Transactional
    @Rollback
    public void testPostDtoToEntityMapping() {
        //GIVEN
        PostDto dto = TestConverterUtils.getPostDto();
        Post expectedEntity = TestConverterUtils.getPost();
        personDao.save(expectedEntity.getPerson());

        //WHEN
        Post actualEntity = mapper.map(dto, Post.class);

        //THEN
        assertThat(actualEntity.getId()).isEqualTo(expectedEntity.getId());
        assertThat(actualEntity.getContent()).isEqualTo(expectedEntity.getContent());
        assertThat(actualEntity.getTitle()).isEqualTo(expectedEntity.getTitle());
        assertThat(actualEntity.getPlaceTime()).isEqualTo(expectedEntity.getPlaceTime());
        assertThat(actualEntity.getPerson()).isEqualTo(expectedEntity.getPerson());
    }

}
