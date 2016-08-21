package com.stwitter.controller;

import com.stwitter.dto.PersonDto;
import com.stwitter.service.InterestService;
import com.stwitter.service.PersonService;
import org.joda.time.LocalDate;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Северская on 17.08.2016.
 */
@Controller
public class RegistrationController {
    @Autowired
    private InterestService interestService;
    @Autowired
    private PersonService personService;

    @RequestMapping({"/registration"})
    public String registration(Model model) {
        model.addAttribute("hobbies", interestService.getAllHobbies());
        return "registration";
    }

    @RequestMapping(value = "/registration/addUser", method = RequestMethod.POST)
    public
    @ResponseBody
    PersonDto registerNewUser(@RequestBody PersonDto person) {
        LocalDate birthdate = ISODateTimeFormat.dateTime().parseLocalDate(person.getBirthday());
        person.setBirthday(birthdate.toString());
        personService.savePerson(person);
        return person;
    }

    @RequestMapping({"/registration/isLoginAvailable"})
    public
    @ResponseBody
    boolean isLoginAvailable(@RequestParam(value = "login") String login) {
        return personService.isLoginAvailable(login);
    }
}
