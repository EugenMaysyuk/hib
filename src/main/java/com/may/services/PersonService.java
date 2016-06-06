package com.may.services;

import com.may.dao.PersonDao;
import com.may.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonService {

    private PersonDao personDao;

    private PersonDao getPersonDao() {
        return personDao;
    }

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void addPerson(Person person) {
        getPersonDao().insert(person);
    }

    public List<Person> fetchAllPersons() {
        return getPersonDao().selectAll();
    }
}