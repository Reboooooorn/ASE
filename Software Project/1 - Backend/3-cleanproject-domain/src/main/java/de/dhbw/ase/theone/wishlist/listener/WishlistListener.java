package de.dhbw.ase.theone.wishlist.listener;

import de.dhbw.ase.theone.wishlist.Wishlist;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

public class WishlistListener {

    private static Log log = LogFactory.getLog(WishlistListener.class);


    @PostPersist
    public void logNewAdded(Wishlist wishlist) {
        log.info(String.format("[WUNSCHLISTE] Neue Wunschliste '%s' (%d) erstellt!",wishlist.getName(),wishlist.getId()));
    }

    @PreUpdate
    public void logUpdateAttempt(Wishlist wishlist) {
        log.info(String.format("[WUNSCHLISTE] Versuche Wunschliste '%s' (%d) zu aktualisieren", wishlist.getName(),wishlist.getId()));
    }

    @PostUpdate
    public void logUpdate(Wishlist wishlist) {
        log.info(String.format("[WUNSCHLISTE] Wunschliste '%s' (%d) aktualisiert!", wishlist.getName(),wishlist.getId()));
    }

    @PostRemove
    public void logRemoval(Wishlist wishlist) {
        log.info(String.format("[WUNSCHLISTE] Wunschliste '%s' (%d) wurde gelöscht!",wishlist.getName(),wishlist.getId()));
    }
}
