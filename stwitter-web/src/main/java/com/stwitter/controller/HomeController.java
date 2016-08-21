package com.stwitter.controller;

import com.stwitter.dto.HobbyDto;
import com.stwitter.dto.PostDto;
import com.stwitter.service.InterestService;
import com.stwitter.service.PersonService;
import com.stwitter.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

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

    @Autowired
    public PersonService personService;

    @Autowired
    public InterestService interestService;


    @RequestMapping({"/home"})
    public String home(Model model) {
        model.addAttribute("latestPosts", postService.getLatestPosts(POSTS_NUMBER));
        model.addAttribute("allPersons", personService.getAllPersons());
        return "home";
    }

    @RequestMapping({"/getLatestStwitts"})
    public
    @ResponseBody
    List<PostDto> getLatestStwitts() {
        return postService.getLatestPosts(POSTS_NUMBER);
    }

    @RequestMapping({"/getAllHobbies"})
    public
    @ResponseBody
    Set<HobbyDto> getAllHobbies() {
        return interestService.getAllHobbies();
    }

    @RequestMapping(value = "/addNewPost", method = RequestMethod.POST)
    public String addNewPost(@RequestBody PostDto post) {
//        post.getPlaceTime();
        return "home";
    }

}
