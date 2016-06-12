package com.may.dao;

import com.may.entities.Info;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Info info) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(info);
        session.getTransaction().commit();
    }

    @Transactional(readOnly = true)
    public List<Info> selectAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Info.class);
        return (List<Info>) criteria.list();
    }
}
