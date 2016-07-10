package com.may.services;

import org.hibernate.SessionFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provide entity of some revision.
 * <p>
 * Created by Eugene on 21-Jun-16.
 */
@Service
public class RevisionInfoService {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Object getEntityAtRevision(Class clazz, Integer revision) {
        AuditQuery query = getAuditReader().createQuery().forEntitiesAtRevision(clazz, revision); // select entities which revisions less that or equal to 'revision'
        query.add(AuditEntity.revisionNumber().eq(revision)); // select only entity which revision equals to passed 'revision'

        return query.getSingleResult();
    }

    private AuditReader getAuditReader() {
        return AuditReaderFactory.get(sessionFactory.getCurrentSession());
    }
}
