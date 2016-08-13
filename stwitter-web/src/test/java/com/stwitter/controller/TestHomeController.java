package com.stwitter.controller;

import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PostDto;
import com.stwitter.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by A.Shcherbina
 * on 19.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class TestHomeController {
    private static final Logger logger = LoggerFactory.getLogger(TestHomeController.class);
    private static final int POSTS_NUMBER = 10;

    @Autowired
    public HomeController homeController;

    @Test
    @Transactional
    public void checkLatestStwits(){
        List<PostDto> posts = homeController.getLatestStwitts();
    }
}
