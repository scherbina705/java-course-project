package com.stwitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by A.Shcherbina
 * on 21.08.2016.
 */
@Controller
public class LoginController {

    @RequestMapping({"/user-login"})
    public String login(Model model) {
        return "user-login";
    }

    @RequestMapping({"/user/stwitts"})
    public String test(Model model) {
        return "home";
    }
}
