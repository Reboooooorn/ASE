package de.dhbw.ase.theone.note;

import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    BaseNote save(BaseNote baseNote);

    HeartNote save(HeartNote heartNote);

    HeadNote save(HeadNote headNote);

    Optional<Note> getNoteByID(long id);

    List<BaseNote> findAllBaseNotes();

    List<HeartNote> findAllHeartNotes();

    List<HeadNote> findAllHeadNotes();
}
