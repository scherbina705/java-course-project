package com.stwitter.controller;

import com.stwitter.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Северская on 17.08.2016.
 */
@Controller
public class RegistrationController {
    @Autowired
    private InterestService interestService;

    @RequestMapping({"/registration"})
    public String registration(Model model) {
        model.addAttribute("hobbies", interestService.getAllHobbies());
        return "registration";
    }
}
