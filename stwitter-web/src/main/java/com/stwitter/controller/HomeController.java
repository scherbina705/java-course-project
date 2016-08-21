package com.stwitter.controller;

import com.stwitter.dto.HobbyDto;
import com.stwitter.dto.PersonDto;
import com.stwitter.dto.PostDto;
import com.stwitter.entity.Person;
import com.stwitter.service.InterestService;
import com.stwitter.service.PersonService;
import com.stwitter.service.PostService;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<PersonDto> persons = personService.getAllPersons();
        model.addAttribute("allPersons", persons);
        Map<String, String> personAvatarNames = new HashMap<>();
        for (PersonDto person : persons){
            personAvatarNames.put(person.getLogin(), person.getAvatarName());
        }
        model.addAttribute("personAvatarsMap", personAvatarNames);
        return "home";
    }

    @RequestMapping(value = "/addNewPost", method = RequestMethod.POST)
    public String addNewPost(@RequestBody PostDto post) {
        post.setPlaceTime(LocalDateTime.now());
        postService.createNewPost(post);
        return "home";
    }

}
