package com.may.dao;

import com.may.entities.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Transactional(readOnly = true)
    public List<Person> retrieveAll() {
        return (List<Person>) sessionFactory.getCurrentSession().createCriteria(Person.class).list();
    }

}