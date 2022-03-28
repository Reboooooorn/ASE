package de.dhbw.ase.theone.plugins.persistence.hibernate.note;

import de.dhbw.ase.theone.note.Note;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataNoteRepository extends JpaRepository<Note, Long> {

    @Query(value = "SELECT * FROM NOTES WHERE NOTE_TYPE LIKE 'Basis%'", nativeQuery = true)
    List<BaseNote> getAllBaseNotes();

    @Query(value = "SELECT * FROM NOTES WHERE NOTE_TYPE LIKE 'Kopf%'", nativeQuery = true)
    List<HeadNote> getAllHeadNotes();

    @Query(value = "SELECT * FROM NOTES WHERE NOTE_TYPE LIKE 'Herz%'", nativeQuery = true)
    List<HeartNote> getAllHeartNotes();

}
