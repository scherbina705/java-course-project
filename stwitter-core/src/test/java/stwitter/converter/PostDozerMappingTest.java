package stwitter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stwitter.dto.PostDto;
import com.stwitter.entity.Post;

import stwitter.util.TestUtils;

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

	@Test
	public void testPostEntityToDtoMapping() {
		//GIVEN
		Post entity = TestUtils.getPost();
		PostDto expectedDto = TestUtils.getPostDto();

		//WHEN
		PostDto actualDto = mapper.map(entity, PostDto.class);

		//THEN
		assertThat(actualDto.getId()).isEqualTo(expectedDto.getId());
	}

	@Test
	public void testPostDtoToEntityMapping() {
		//GIVEN
		PostDto dto = TestUtils.getPostDto();
		Post expectedEntity = TestUtils.getPost();

		//WHEN
		Post actualEntity = mapper.map(dto, Post.class);

		//THEN
		assertThat(actualEntity.getId()).isEqualTo(expectedEntity.getId());
	}

}
