package de.dhbw.ase.theone.manufacturer.listener;

import de.dhbw.ase.theone.manufacturer.Manufacturer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

public class ManufacturerListener {

    private static Log log = LogFactory.getLog(ManufacturerListener.class);

    @PrePersist
    public void logNewAttempt(Manufacturer manufacturer) {
        log.info(String.format("[HERSTELLER] Versuche einen neuen Hersteller '%s' zu erstellen", manufacturer.getName()));
    }

    @PostPersist
    public void logNewAdded(Manufacturer manufacturer) {
        log.info(String.format("[HERSTELLER] Neuer Hersteller '%s' ('%d') wurde erstellt!", manufacturer.getName(), manufacturer.getId()));
    }

    @PreRemove
    public void logRemovalAttempt(Manufacturer manufacturer) {
        log.info(String.format("[HERSTELLER] Versuche den Hersteller '%s' ('%d') zu löschen!", manufacturer.getName(), manufacturer.getId()));
    }

    @PostRemove
    public void logRemoval(Manufacturer manufacturer) {
        log.info(String.format("[HERSTELLER] Hersteller '%s' ('%d') wurde gelöscht!", manufacturer.getName(),manufacturer.getId()));
    }

    @PreUpdate
    public void logUpdateAttempt(Manufacturer manufacturer) {
        log.info(String.format("[HERSTELLER] Versuche den Hersteller '%s' ('%d') zu aktualisieren", manufacturer.getName(), manufacturer.getId()));
    }

    @PostUpdate
    public void logUpdate(Manufacturer manufacturer) {
        log.info(String.format("[HERSTELLER] Hersteller '%s' ('%d') wurde aktualisiert", manufacturer.getName(), manufacturer.getId()));
    }

    @PostLoad
    public void logLoad(Manufacturer manufacturer) {
        log.info(String.format("[HERSTELLER] Versuche den Hersteller '%s' ('%d') zu laden", manufacturer.getName(), manufacturer.getId()));
    }

}
