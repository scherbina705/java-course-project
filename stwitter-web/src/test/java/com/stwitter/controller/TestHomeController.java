package com.stwitter.controller;

import com.stwitter.dto.PostDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by A.Shcherbina
 * on 19.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class TestHomeController {

    @Autowired
    public HomeController homeController;

    @Test
    @Transactional
    public void checkLatestStwits() {
        List<PostDto> posts = homeController.getLatestStwitts();
        assertThat(posts.size()).isNotZero();
    }
}
