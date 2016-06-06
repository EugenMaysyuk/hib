package com.may.controllers;

import com.may.entities.Person;
import com.may.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 *  Created by EugenMaysyuk on 1/15/2016.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String indexHandler(ModelMap model) {

        Person person = new Person();
        person.setName("Eugen");
        person.setEmail("eugen@gmail.com");

        personService.addPerson(person);
        System.out.println("Person: " + person + " added successfully");

        List<Person> persons = personService.fetchAllPersons();
        System.out.println("The list of all persons: " + persons);

        return "index";
    }

}
