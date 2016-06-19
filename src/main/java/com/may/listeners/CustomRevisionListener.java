package com.may.listeners;

import com.may.entities.CustomRevisionEntity;
import com.may.utils.UserUtils;
import org.hibernate.envers.RevisionListener;

/**
 * This class needs for logging custom data for revisions.
 *
 * To fill the entity with additional data, you'll need to implement the org.jboss.envers.RevisionListener interface.
 * Its newRevision method will be called when a new revision is created, before persisting the revision entity.
 * The implementation should be stateless and thread-safe.
 * The listener then has to be attached to the revisions entity by specifying it
 * as a parameter to the @RevisionEntity annotation.
 *
 * Created by Eugene on 19-Jun-16.
 */
public class CustomRevisionListener implements RevisionListener {

    public void newRevision(Object revisionEntity) {
        CustomRevisionEntity exampleRevEntity = (CustomRevisionEntity) revisionEntity;
        exampleRevEntity.setUsername(UserUtils.getCurrentUser());
    }
}
