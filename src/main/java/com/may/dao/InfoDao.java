package com.may.dao;

import com.may.entities.Info;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Info info) {
        sessionFactory.getCurrentSession().save(info);
    }

    @Transactional(readOnly = true)
    public List<Info> selectAll() {
        return sessionFactory.getCurrentSession().createQuery("from Info").list();
    }
}
