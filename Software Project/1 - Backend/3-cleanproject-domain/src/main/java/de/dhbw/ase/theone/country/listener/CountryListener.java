package de.dhbw.ase.theone.country.listener;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;

public class CountryListener {

    private static Log log = LogFactory.getLog(CountryListener.class);

    @PostPersist
    public void logNewAdded(Country country) {
        log.info(String.format("[LAND] Neues Land '%s' [%s] (%d) erstellt!",country.getName(),country.getAbbreviation(),country.getId()));
    }

    @PostRemove
    public void logRemoval(Country country) {
        log.info(String.format("[LAND] Land '%s'[%s] ('%d') wurde gelöscht!", country.getName(),country.getAbbreviation(),country.getId()));
    }
}
