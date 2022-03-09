package de.dhbw.ase.theone.collection.listener;

import de.dhbw.ase.theone.collection.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

public class CollectionListener {

    private static Log log = LogFactory.getLog(CollectionListener.class);

    @PostPersist
    public void logNewAdded(Collection collection) {
        log.info(String.format("[KOLLEKTION] Neue Kollektion '%s' (%d) erstellt!", collection.getName(), collection.getId()));
    }

    @PreUpdate
    public void logUpdateAttempt(Collection collection) {
        log.info(String.format("[KOLLEKTION] Versuche Kollektion '%s' (%d) zu aktualisieren", collection.getName(), collection.getId()));
    }

    @PostUpdate
    public void logUpdate(Collection collection) {
        log.info(String.format("[KOLLEKTION] Kollektion '%s' (%d) aktualisiert!", collection.getName(), collection.getId()));
    }

    @PostRemove
    public void logRemoval(Collection collection) {
        log.info(String.format("[KOLLEKTION] Kollektion '%s' (%d) wurde gelöscht!", collection.getName(), collection.getId()));
    }

}
