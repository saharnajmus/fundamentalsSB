package com.pluralsite.fundamentalsSB.web;

import com.pluralsite.fundamentalsSB.service.PassportService;
import com.pluralsite.fundamentalsSB.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Spring will consider this class when handling incoming web requests.
@Controller
public class PersonController {

    private final PersonService personService;

    private final PassportService passportService;

    public PersonController(PersonService personService, PassportService passportService) {
        this.personService = personService;
        this.passportService = passportService;
    }

    @GetMapping("/persons")
    public String retrievePersonInfo(Model model){
        model.addAttribute("persons",personService.listPersons());
        return "persons";

    }

    @GetMapping("/passports")
    public String retrievePassports(Model model){
        //the model is what gets displayed on the view
        model.addAttribute("passports",passportService.listPassports());
        return "passport";

    }


}
