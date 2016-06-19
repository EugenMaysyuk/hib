package com.may.controllers;

import com.may.entities.Info;
import com.may.entities.Person;
import com.may.services.InfoService;
import com.may.services.PersonService;
import com.may.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    PersonService personService;

    @Autowired
    InfoService infoService;

    @RequestMapping(method = RequestMethod.GET)
    public String indexHandler() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "savePerson/{name}/{email}")
    public String savePerson(@PathVariable String name, @PathVariable String email) {
        UserUtils.setCurrentUser("Eugen");
        Person person = new Person();
        person.setName(name);
        person.setEmail(email);

        personService.save(person);

        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "saveInfo/{bankId}/{text1}/{text2}/{text3}")
    public String saveInfo(@PathVariable Integer bankId, @PathVariable String text1,@PathVariable String text2, @PathVariable String text3) {
        UserUtils.setCurrentUser("Pavel");
        Info info = new Info();
        info.setBankId(bankId);
        info.setText1(text1);
        info.setText2(text2);
        info.setText3(text3);

        infoService.save(info);

        return "index";
    }

}
