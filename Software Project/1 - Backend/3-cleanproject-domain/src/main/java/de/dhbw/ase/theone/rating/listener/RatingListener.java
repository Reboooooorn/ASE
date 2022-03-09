package de.dhbw.ase.theone.rating.listener;

import de.dhbw.ase.theone.rating.Rating;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;

public class RatingListener {

    private static Log log = LogFactory.getLog(RatingListener.class);


    @PostPersist
    public void logNewAdded(Rating rating) {
        log.info(String.format("[RATING] Neues Rating (%d) für das Parfume '%s'(%d) erstellt!", rating.getId(), rating.getPerfume().getName(), rating.getPerfume().getId()));
    }

    @PostRemove
    public void logRemoval(Rating rating) {
        log.info(String.format("[RATING] Rating (%d) für das Parfume '%s'(%d) wurde gelöscht!", rating.getId(), rating.getPerfume().getName()));
    }
}
