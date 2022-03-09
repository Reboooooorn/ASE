package de.dhbw.ase.theone.note.listener;

import de.dhbw.ase.theone.note.Note;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;

public class NoteListener {

    private static Log log = LogFactory.getLog(NoteListener.class);

    @PostPersist
    public void logNewAdded(Note note) {
        log.info(String.format("[DUFT] Neuer Duft [%s] '%s' (%d) mit dem Geruch '%s' erstellt!", note.getClass().getSimpleName(), note.getName(), note.getId(), note.getSmell()));
    }

    @PostRemove
    public void logRemoval(Note note) {
        log.info(String.format("[DUFT] Duft [%s] '%s' (%d) mit dem Geruch '%s' wurde gelöscht!", note.getClass().getSimpleName(), note.getName(), note.getId(), note.getSmell()));
    }
}
