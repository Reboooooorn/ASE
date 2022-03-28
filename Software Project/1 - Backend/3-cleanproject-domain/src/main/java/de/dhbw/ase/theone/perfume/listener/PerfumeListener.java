package de.dhbw.ase.theone.perfume.listener;

import de.dhbw.ase.theone.perfume.Perfume;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

public class PerfumeListener {

    private static Log log = LogFactory.getLog(PerfumeListener.class);

    @PostPersist
    public void logNewAdded(Perfume perfume) {
        log.info(String.format("[PARFÜM] Neues Parfüm '%s' ('%d') wurde erstellt!", perfume.getName(), perfume.getId()));
    }

    @PostRemove
    public void logRemoval(Perfume perfume) {
        log.info(String.format("[PARFÜM] Parfüm '%s' ('%d') wurde gelöscht!", perfume.getName(),perfume.getId()));
    }

    @PostUpdate
    public void logUpdate(Perfume perfume) {
        log.info(String.format("[PARFÜM] Parfüm '%s' ('%d') wurde aktualisiert", perfume.getName(), perfume.getId()));
    }
}
