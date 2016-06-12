package com.may.services;

import com.may.dao.PersonDao;
import com.may.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public void save(Person person) {
        personDao.save(person);
    }

    public List<Person> retrieveAll() {
        return personDao.retrieveAll();
    }
}