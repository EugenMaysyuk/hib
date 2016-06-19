package com.may.entities;

import com.may.listeners.CustomRevisionListener;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.Entity;

/**
 * This class needs for logging custom data for revisions.
 *
 * Envers provides an easy way to log additional data for each revision.
 * You simply need to annotate one entity with @RevisionEntity, and a new instance of this entity
 * will be persisted when a new revision is created (that is, whenever an audited entity is modified).
 * As revisions are global, you can have at most one revisions entity.
 *
 * This entity must have at least two properties:
 *   1. an integer- or long-valued property, annotated with @RevisionNumber.
 *   Most often, this will be an auto-generated primary key.
 *
 *   2. a long- or j.u.Date- valued property, annotated with @RevisionTimestamp.
 *   Value of this property will be automatically set by Envers.
 *
 * You can either add these properties to your entity,
 * or extend org.hibernate.envers.DefaultRevisionEntity, which already has those two properties.
 *
 * Created by Eugene on 19-Jun-16.
 */
@Entity
@RevisionEntity(CustomRevisionListener.class)
public class CustomRevisionEntity extends DefaultRevisionEntity {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
