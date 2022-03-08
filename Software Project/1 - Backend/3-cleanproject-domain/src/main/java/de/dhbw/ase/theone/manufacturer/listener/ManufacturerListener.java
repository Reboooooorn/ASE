package de.dhbw.ase.theone.manufacturer.listener;

import de.dhbw.ase.theone.manufacturer.Manufacturer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

public class ManufacturerListener {

    private static Log log = LogFactory.getLog(ManufacturerListener.class);

    @PostPersist
    public void logNewAdded(Manufacturer manufacturer) {
        log.info(String.format("[HERSTELLER] Neuer Hersteller '%s' ('%d') wurde erstellt!", manufacturer.getName(), manufacturer.getId()));
    }

    @PostRemove
    public void logRemoval(Manufacturer manufacturer) {
        log.info(String.format("[HERSTELLER] Hersteller '%s' ('%d') wurde gelöscht!", manufacturer.getName(),manufacturer.getId()));
    }

}
