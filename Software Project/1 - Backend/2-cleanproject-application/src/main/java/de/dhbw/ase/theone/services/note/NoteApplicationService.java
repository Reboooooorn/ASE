package de.dhbw.ase.theone.services.note;

import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import de.dhbw.ase.theone.note.Note;
import de.dhbw.ase.theone.note.NoteRepository;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteApplicationService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteApplicationService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<BaseNote> getAllBasicNotes() {
        return noteRepository.findAllBaseNotes();
    }

    public List<HeartNote> getAllHeartNotes() {
        return noteRepository.findAllHeartNotes();
    }

    public List<HeadNote> getAllHeadNotes() {
        return noteRepository.findAllHeadNotes();
    }
}
