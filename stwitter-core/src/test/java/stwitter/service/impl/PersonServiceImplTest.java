package stwitter.service.impl;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.stwitter.service.impl.PersonServiceImpl;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class PersonServiceImplTest {
	@Autowired
	private PersonServiceImpl personService;

	@Autowired
	private DozerBeanMapper mapper;

	@Test
	@Transactional
	@Rollback(true)
	public void test1() {

	}
}
