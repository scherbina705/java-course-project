package com.stwitter.controller;

import com.stwitter.dto.Post;
import com.stwitter.dto.User;
import com.stwitter.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final int POSTS_NUMBER = 10;

    @Autowired
    public PostService postService;

    @RequestMapping({"/home"})
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        model.addAttribute("latestPosts", postService.getLatestPosts(POSTS_NUMBER));
        return "home";
    }

    @RequestMapping({"/getLatestStwitts"})
    public
    @ResponseBody
    List<Post> getLatestStwitts() {
        return postService.getLatestPosts(POSTS_NUMBER);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user, Map<String, Object> model, HttpServletRequest request) {
        user.getEmail();
        return "home";
    }

}
