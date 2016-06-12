package com.may.dao;

import com.may.entities.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
    }

    public List<Person> retrieveAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Person.class);
        return (List<Person>) criteria.list();
    }

}