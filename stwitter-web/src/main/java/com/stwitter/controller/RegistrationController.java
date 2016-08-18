package com.stwitter.controller;

import com.stwitter.dto.PersonDto;
import com.stwitter.service.InterestService;
import com.stwitter.service.PersonService;
import org.joda.time.LocalDate;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String addStudent(@ModelAttribute PersonDto person,
                             ModelMap model) {
        LocalDate birthdate = ISODateTimeFormat.dateTime().parseLocalDate(person.getBirthday());
        person.setBirthday(birthdate.toString());
//        personService.savePerson(person);
        return "result";
    }
}
